import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZipper extends JFrame {
    private JPanel panel;
    private JButton removeButton;
    ArrayList pathList = new ArrayList();
    private JButton addButton;
    private JButton zipButton;
    private DefaultListModel modelList = new DefaultListModel() {
        @Override
        public void addElement(Object element) {
            lista.add(element);
            super.addElement(((File) element).getName());
        }

        @Override
        public Object get(int index) {
            return lista.get(index);
        }

        @Override
        public Object remove(int index) {
            lista.remove(index);
            return super.remove(index);
        }


        ArrayList lista = new ArrayList();

    };
    private JList list1;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JComboBox plikBar;
    private JFileChooser chooser = new JFileChooser();

    public FileZipper() {
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFromArch();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToArch();
            }
        });
        zipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createZip();
            }
        });

        JMenuItem dodajItem = new JMenuItem("Dodaj");
        JMenuItem usunItem = new JMenuItem("Usuń");
        JMenuItem zipItem = new JMenuItem("Zip");
        list1.setModel(modelList);
        plikBar.addItem(dodajItem.getText());
        plikBar.addItem(usunItem.getText());
        plikBar.addItem(zipItem.getText());

    }

    private void addToArch() {
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setMultiSelectionEnabled(true);
        int tmp = chooser.showDialog(panel, "Add to archive");
        list1.setModel(modelList);
        if (tmp == 0) {
            File[] paths = chooser.getSelectedFiles();
            for (int i = 0; i < paths.length; i++) {
                if (!isRepeated(paths[i].getPath())) {
                    modelList.addElement(paths[i]);
                }
            }
        }
    }

    private boolean isRepeated(String test) {
        for (int i = 0; i < modelList.getSize(); i++) {
            File testek = (File) modelList.get(i);
            if (testek.getPath().equals(test)) {
                return true;
            }
        }
        return false;
    }

    private void deleteFromArch() {
        int[] tmp = list1.getSelectedIndices();

        for (int i = 0; i < tmp.length; i++) {
            modelList.remove(tmp[i] - i);
        }
    }

    private void createZip() {
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        chooser.setSelectedFile(new File(System.getProperty("user.dir") + File.separator + "yourFile.zip"));
        int tmp = chooser.showDialog(panel, "Compress");
        final int BUFFOR = 1024;
        byte tmpData[] = new byte[BUFFOR];

        if (tmp == 0) {
            try {
                ZipOutputStream zOutS = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(chooser.getSelectedFile()), BUFFOR));

                for (int i = 0; i < modelList.getSize(); i++) {
                    File temp = (File) modelList.get(i);
                    if (!temp.isDirectory()) {
                        zipIt(zOutS, temp, tmpData, ((File) modelList.get(i)).getPath());
                    } else {
                        wypiszSciezki((File) modelList.get(i));

                        for (int j = 0; j < pathList.size(); j++) {
                            zipIt(zOutS, (File) pathList.get(j), tmpData, ((File) modelList.get(i)).getPath());
                        }
                        pathList.removeAll(pathList);
                    }
                }

                zOutS.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void zipIt(ZipOutputStream zOutS, File filePath, byte[] tmpData, String bazowa) throws IOException {
        final int BUFFOR = 1024;
        BufferedInputStream inS = null;
        try {
            inS = new BufferedInputStream(new FileInputStream(filePath), BUFFOR);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            zOutS.putNextEntry(new ZipEntry(filePath.getPath().substring(bazowa.lastIndexOf(File.separator )+1)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int counter;
        while ((counter = inS.read(tmpData, 0, BUFFOR)) != -1)
            zOutS.write(tmpData, 0, counter);


        zOutS.closeEntry();

        inS.close();
    }

    private void wypiszSciezki(File nazwaSciezki) {
        String[] nazwyPlikowIKatalogow = nazwaSciezki.list();


        for (int i = 0; i < nazwyPlikowIKatalogow.length; i++) {
            File p = new File(nazwaSciezki.getPath(), nazwyPlikowIKatalogow[i]);

            if (p.isFile()) {
                pathList.add(p);
            }
            if (p.isDirectory()) {
                wypiszSciezki(new File(p.getPath()));
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyZipp");
        frame.setContentPane(new FileZipper().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(300, 300, 600, 600);
        Dimension dimension = new Dimension(600, 600);
        frame.setMinimumSize(dimension);
        frame.setVisible(true);
    }
}

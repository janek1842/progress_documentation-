package gui;

import poczta.FolderKonta;
import poczta.Klient;
import poczta.ListaInt;
import poczta.Wiadomosc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Map;

public class OknoGlowneGUI extends JFrame{
    private JPanel panelGlowny;
    private JList <Wiadomosc> listaWiadomosci;
    private JButton napiszWiadomoscButton;
    private JList listaFolderow;
    private JScrollPane folderyScrollPane;
    private JButton odswiezButton;
    private JButton wylogujButton;
    private JMenuBar UstawieniaPersonalne;
    private JMenuBar UstawieniaOgólne;
    private JMenuBar DarkMode;
    private JMenuBar Info;
    private JMenu MenuUstPer;
    private JMenuItem Wyloguj;
    private JMenuItem trybJasny;
    private JMenuItem trybCiemny;
    private JMenu UstawieniaMenu;
    private JMenuItem Pomoc;
    private JMenuItem Kontakt;
    private JMenuItem oProjekcie;
    private JMenuItem infoKonto;
    private JButton usuńWiadomośćButton;
    private JScrollPane scrollPane;
    private JFrame oknoGlowne;
    private Klient klient;

    public OknoGlowneGUI(Klient klient, JRadioButton Button){
        this.klient = klient;
        oknoGlowne = new JFrame("OknoGlowne");
        oknoGlowne.setContentPane(panelGlowny);
        oknoGlowne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oknoGlowne.pack();
        oknoGlowne.setVisible(true);
        listaWiadomosci.setModel(wczytajWszytkieWiadomosci("Wyslane"));

        listaWiadomosci.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JList lista = (JList) e.getSource();
                if (e.getClickCount() == 2) {
                    int index = lista.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        Wiadomosc o = new Wiadomosc();
                        o =  (Wiadomosc) lista.getModel().getElementAt(index);
                        System.out.println("Kliknieto: " + o.toString());
                        JFrame f = new OdczytanieWiadomosciGUI(klient,o,panelGlowny.getBackground());
                        f.pack();
                        f.setVisible(true);
                    }
                }
            }
        });

        odswiezButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                klient.synchronizuj();
                listaWiadomosci.setModel(wczytajWszytkieWiadomosci((String)listaFolderow.getSelectedValue()));
            }
        });
        listaFolderow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JList lista = (JList) e.getSource();
                klient.synchronizuj();
                listaWiadomosci.setModel(wczytajWszytkieWiadomosci((String)lista.getSelectedValue()));
            }
        });
        napiszWiadomoscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new WysylanieWiadomosciGUI(klient,panelGlowny.getBackground());
                f.pack();
                f.setVisible(true);
            }
        });

        oknoGlowne.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.out.println("Zamykam program");
                if(!Button.isSelected())
                {
                 klient.wyloguj();
                }
                klient.zapiszBaze();
                System.exit(0);
            }
        });

        Wyloguj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Button.isSelected())
                {
                    klient.wyloguj();
                    oknoGlowne.dispose();
                }
                klient.zapiszBaze();
                KlientGUI klient1 = new KlientGUI();
                oknoGlowne.dispose();
            }
        });
        Kontakt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panelGlowny, "Skontaktuj sie z nami ! \nMichał Kurdziel: mkurdziel@student.agh.edu.pl \nJan Ściga: sciga@student.agh.edu.pl");
            }
        });
        oProjekcie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panelGlowny, "Projekt Poczta Elektroniczna został stworzony w toku realizacji przedmiotu Programowanie Obiektowe w roku akademickim 2020/2021.\nŻyczymy przyjemnego poruszania się po interfejsie Poczty ! ");
            }
        });

        infoKonto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new InformacjeoKoncieGUI(klient,panelGlowny.getBackground());
                f.pack();
                f.setVisible(true);
            }
        });
        Pomoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panelGlowny, " Napisz Wiadomość- przenosi do formularza pisania wiadomości\n Usuń Wiadomość- usuwanie wiadomości\n Odśwież- Umożliwia aktualizację konta\n Foldery w lewym dolnym rogu pozwalają przeglądać wiadomości \n Menu na górze pomaga w poruszaniu się po koncie");
            }
        });
        trybCiemny.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelGlowny.setBackground(Color.darkGray);
                listaFolderow.setBackground(Color.DARK_GRAY);
                listaWiadomosci.setBackground(Color.DARK_GRAY);
                odswiezButton.setBackground(Color.darkGray);
                napiszWiadomoscButton.setBackground(Color.darkGray);
                listaFolderow.setForeground(Color.white);
                listaWiadomosci.setForeground(Color.white);
                odswiezButton.setForeground(Color.white);
                napiszWiadomoscButton.setForeground(Color.white);
                usuńWiadomośćButton.setBackground(Color.darkGray);
                usuńWiadomośćButton.setForeground(Color.white);
            }
        });
        trybJasny.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelGlowny.setBackground(Color.white);
                listaFolderow.setBackground(Color.white);
                listaWiadomosci.setBackground(Color.white);
                odswiezButton.setBackground(Color.white);
                napiszWiadomoscButton.setBackground(Color.white);
                listaFolderow.setForeground(Color.black);
                listaWiadomosci.setForeground(Color.black);
                odswiezButton.setForeground(Color.black);
                napiszWiadomoscButton.setForeground(Color.black);
                usuńWiadomośćButton.setForeground(Color.darkGray);
                usuńWiadomośćButton.setBackground(Color.white);
            }
        });
        usuńWiadomośćButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int czyUsunacNaStale = JOptionPane.showConfirmDialog(panelGlowny, "Czy usunać wiadomość na stałe ?");
                //zwraca 1 gdy "No" 0 gdy Yes
                ArrayList <Integer> listaId = new ArrayList<Integer>();
                DefaultListModel model = (DefaultListModel) listaWiadomosci.getModel();
                if(listaWiadomosci.getSelectedIndices().length > 0) {
                    int[] wybraneIndeksy = listaWiadomosci.getSelectedIndices();
                    for (int i = wybraneIndeksy.length - 1; i >= 0; i--) {
                        Wiadomosc wiadomosc = (Wiadomosc) model.getElementAt(wybraneIndeksy[i]);
                        if (czyUsunacNaStale==1) {
                            listaId.add(wiadomosc.getId());
                            klient.getBazaDanych().getAktFolderKonta().usunWiadomosc(wiadomosc.getId(),false);
                        }
                        else {
                            klient.getBazaDanych().getAktFolderKonta().usunWiadomosc(wiadomosc.getId(),true);
                            listaId.add(-wiadomosc.getId());
                        }
                        model.removeElementAt(wybraneIndeksy[i]);
                    }

                }
                klient.wyslij(new ListaInt(listaId,"usunWiadomosci"));
            }
        });
    }

    public DefaultListModel <Wiadomosc> wczytajWiadomosci(String folder,int poczatek, int ile){
        //HashMap <Integer,String> listaId = klient.getBazaDanych().getAktListaId();
        FolderKonta folderKonta = klient.getBazaDanych().getAktFolderKonta();
        Wiadomosc wiadomosc;

        DefaultListModel <Wiadomosc> listaWiad = new DefaultListModel<>();


        for (int i = poczatek; i < poczatek+ile; i++){
            if (folderKonta.getListaId().containsKey(i) && folderKonta.getListaId().get(i).equals(folder)) {
                wiadomosc = folderKonta.czytajwiadomosc(i);
                listaWiad.addElement(wiadomosc);
                wiadomosc.wyswietl();
            }
            else if (folderKonta.kolejneId() - 1 <= poczatek+ile) ile++; //TODO: nwm czy dobre
        }
        return listaWiad;
    }

    public DefaultListModel <Wiadomosc> wczytajWszytkieWiadomosci(String folder){
        FolderKonta folderKonta = klient.getBazaDanych().getAktFolderKonta();
        DefaultListModel <Wiadomosc> listaWiad = new DefaultListModel<>();

        for(Map.Entry m : folderKonta.getListaId().entrySet()){
            if(m.getValue().equals(folder)){
                listaWiad.addElement(folderKonta.czytajwiadomosc((Integer)m.getKey()));
            }
        }
        return listaWiad;
    }
    // public static void main(String[] args) {
   //  new OknoGlowne(new poczta.Klient("localhost",2300));

  //  }


}

package Lab6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SamochodGUI extends Thread {
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton dodajNowyButton;
    private JButton usuńButton;
    private JTextField NrRejeTX;
    private JTextField WagaSTX;
    private JTextField PredkoscTX;
    private JTextField ModelTX;
    private JButton wyłączButton;
    private JButton włączButton;
    private JTextField SkrzNazwa;
    private JTextField SkrzCen;
    private JTextField SkrzyWa;
    private JTextField SkrzBieg;
    private JTextField SilNaz;
    private JTextField SilCen;
    private JTextField SilWag;
    private JTextField SilObr;
    private JTextField SprzNaz;
    private JTextField SprzCen;
    private JTextField SprzWag;
    private JTextField SprzSta;
    private JButton ZwiekszBieg;
    private JButton ZmniejszBieg;
    private JButton SprzegloNacisnij;
    private JButton SprzegloZwolnij;
    private JButton DodajGazu;
    private JButton UjmijGazu;
    private JPanel mapa;
    private JLabel Icon;
    private Sprzeglo spr;
    private SkrzyniaBiegow skr;
    private Silnik sil;
    private Samochod Sam;


    public SamochodGUI() {
        spr = new Sprzeglo("spr", 40, 60, true);
        skr = new SkrzyniaBiegow("skrz1", 50, 50, 5, spr, 100);
        sil = new Silnik("Diesel", 10, 60, 1000);
        Sam = new Samochod("KR01", "Audi", 70000, sil, skr, spr);

        comboBox1.addItem(Sam);

        start();

        włączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Sam.wlacz();
                    refresh();
                }
                catch (Exception f)
                {

                }
                
            }
        });

        ZwiekszBieg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Sam.isStanWlaczenia()) {
                    Sam.skrzynia.zwiekszBieg();
                    refresh();
                }
            }
        });

        ZmniejszBieg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sam.skrzynia.zmniejszBieg();
                refresh();
            }
        });
        SprzegloNacisnij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sam.sprzeglo.wcisnij();
                refresh();
            }
        });
        SprzegloZwolnij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sam.sprzeglo.zwolnij();
                refresh();
            }
        });
        DodajGazu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Sam.isStanWlaczenia()) {
                    Sam.silnik.zwiekszObroty(1);
                    Sam.zwAktPredkosc();
                    refresh();
                }
            }
        });
        UjmijGazu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Sam.isStanWlaczenia()) {
                    Sam.silnik.zmniejszObroty(1);
                    Sam.zmAktPredkosc();
                    refresh();
                }
            }
        });
        wyłączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sam.silnik.zatrzymaj();
                Sam.wylacz();
                Sam.skrzynia.setAktualnyBieg(0);

            }
        });
        mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    Sam.cel = new Pozycja(e.getX(), e.getY());
                    Sam.jedzDo(new Pozycja(e.getX(), e.getY()));
                }
                catch (Exception g)
                {

                }
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Sam = (Samochod) comboBox1.getSelectedItem();
                refresh();
            }
        });
        usuńButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Sam.setStanWlaczenia(false);
                comboBox1.removeItem(Sam);
            }
        });
        dodajNowyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new formularz(comboBox1);
                f.pack();
                f.setVisible(true);
            }
        });
    }

    @Override
        public void run () {
        super.run();
        while (true) {
            try {
                Thread.sleep(50);
                refresh();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    private void refresh() {
        if(Sam == null)
        {
            Icon.setVisible(false);
            NrRejeTX.setText("");
            ModelTX.setText("");
            WagaSTX.setText("");
            PredkoscTX.setText("");
            SkrzNazwa.setText("");
            SkrzBieg.setText("");
            SkrzCen.setText("");
            SkrzyWa.setText("");
            SkrzBieg.setText("");
            SilNaz.setText("");
            SilCen.setText("");
            SilWag.setText("");
            SilObr.setText("");
            SprzNaz.setText("");
            SprzCen.setText("");
            SprzWag.setText("");
            SprzSta.setText("");

        }
        else {
            Icon.setVisible(true);
            ModelTX.setText(Sam.getModel());
            NrRejeTX.setText(Sam.getNrRejest());
            WagaSTX.setText(Double.toString(Sam.getWaga()));
            PredkoscTX.setText(Double.toString(Sam.getAktPredkosc()));
            SkrzNazwa.setText(Sam.skrzynia.getNazwa());
            SkrzBieg.setText(Sam.skrzynia.getNazwa());
            SkrzCen.setText(Double.toString(Sam.skrzynia.getCena()));
            SkrzyWa.setText(Double.toString(Sam.skrzynia.getWaga()));
            SkrzBieg.setText(Double.toString(Sam.skrzynia.getAktualnyBieg()));
            SilNaz.setText((Sam.silnik.getNazwa()));
            SilCen.setText(Double.toString(Sam.silnik.getCena()));
            SilWag.setText(Double.toString(Sam.silnik.getWaga()));
            SilObr.setText(Double.toString(Sam.silnik.getobroty()));
            SprzNaz.setText(Sam.sprzeglo.getNazwa());
            SprzCen.setText(Double.toString(Sam.sprzeglo.getCena()));
            SprzWag.setText(Double.toString(Sam.sprzeglo.getWaga()));
            SprzSta.setText(Sam.sprzeglo.isStanSprzegla());
            Sam.setWaga();
            Icon.setLocation((int) Sam.getAktualnaPozycja().getX(), (int) Sam.getAktualnaPozycja().getY());
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("SamochodGUI");
        frame.setContentPane(new SamochodGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}



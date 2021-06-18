package gui;

import poczta.Klient;
import poczta.Wiadomosc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OdczytanieWiadomosciGUI extends JFrame {
    private JPanel OdczytanieWiadomosci;
    private JTextField Nadawca;
    private JTextField Temat;
    private JTextArea TekstWiadomosci;
    private JButton odpowiedzButton;
    private JButton anulujButton;
    private JPanel tlo1;
    private JPanel tlo2;
    private JLabel nadawcaTxt;
    private JLabel tematTxT;
    private JPanel tloNaDole;
    private JLabel odbiorcaTxt;
    private JTextField Odbiorca;
    private Klient klient;

    public OdczytanieWiadomosciGUI(Klient klient, Wiadomosc wiadomosc, Color color)
     {
         if(color== Color.darkGray)
         {
             tloNaDole.setBackground(Color.darkGray);
             OdczytanieWiadomosci.setBackground(Color.darkGray);
             Nadawca.setBackground(Color.darkGray);
             Odbiorca.setBackground(Color.darkGray);
             Temat.setBackground(Color.darkGray);
             TekstWiadomosci.setBackground(Color.darkGray);
             odpowiedzButton.setBackground(Color.darkGray);
             anulujButton.setBackground(Color.darkGray);
             OdczytanieWiadomosci.setForeground(Color.white);
             Nadawca.setForeground(Color.white);
             Temat.setForeground(Color.white);
             Odbiorca.setForeground(Color.white);
             TekstWiadomosci.setForeground(Color.white);
             odpowiedzButton.setForeground(Color.white);
             anulujButton.setForeground(Color.white);
             tlo1.setBackground(Color.darkGray);
             tlo2.setBackground(Color.darkGray);
             tlo1.setForeground(Color.white);
             tlo2.setForeground(Color.white);
             nadawcaTxt.setForeground(Color.white);
             odbiorcaTxt.setForeground(Color.white);
             tematTxT.setForeground(Color.white);
         }
        this.klient = klient;
        setContentPane(OdczytanieWiadomosci);
        Nadawca.setText(wiadomosc.getNadawca());
        Odbiorca.setText(wiadomosc.getOdbiorca());
        Temat.setText(wiadomosc.getTemat());
        TekstWiadomosci.setText(wiadomosc.getTekst());

        odpowiedzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new WysylanieWiadomosciGUI(klient,wiadomosc,OdczytanieWiadomosci.getBackground());
                f.pack();
                f.setVisible(true);
                dispose();
            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}

package gui;

import poczta.Klient;
import poczta.Wiadomosc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WysylanieWiadomosciGUI extends JFrame {
    private JTextArea tekstWiadomosci;
    private JTextField Odbiorca;
    private JTextField Temat;
    private JButton wyslijWiadomoscButton;
    private JButton anulujButton;
    private JPanel wysylanieWiadomosci;
    private JLabel odbiorcaText;
    private JLabel tematText;
    private JPanel tlo;
    private JPanel tlo2;
    private Klient klient;

    public WysylanieWiadomosciGUI(Klient klient, Color color) {
        this.klient = klient;
        if(color==Color.darkGray){
            Odbiorca.setBackground(Color.darkGray);
            tekstWiadomosci.setBackground(Color.darkGray);
            Temat.setBackground(Color.darkGray);
            wyslijWiadomoscButton.setBackground(Color.darkGray);
            anulujButton.setBackground(Color.darkGray);
            wysylanieWiadomosci.setBackground(Color.darkGray);
            odbiorcaText.setBackground(Color.darkGray);
            tematText.setBackground(Color.darkGray);
            tlo.setBackground(Color.darkGray);
            Odbiorca.setForeground(Color.white);
            tekstWiadomosci.setForeground(Color.white);
            Temat.setForeground(Color.white);
            wyslijWiadomoscButton.setForeground(Color.white);
            anulujButton.setForeground(Color.white);
            wysylanieWiadomosci.setForeground(Color.white);
            odbiorcaText.setForeground(Color.white);
            tematText.setForeground(Color.white);
            tlo.setForeground(Color.white);
            tlo2.setBackground(Color.darkGray);
        }
        setContentPane(wysylanieWiadomosci);
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        wyslijWiadomoscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Wiadomosc wiadomosc = new Wiadomosc("mail", Odbiorca.getText(), klient.getBazaDanych().getAktualneKonto().getEmail(), Temat.getText(),tekstWiadomosci.getText());
                    klient.wyslij(wiadomosc);
                    dispose();
                } catch (Exception f) {
                    System.out.println("BLAD WYSYŁANIA WIADOMOŚCI");
                    JOptionPane.showMessageDialog(wysylanieWiadomosci, "Błąd wysyłania wiadomości");
                    dispose();
                }
            }
        });

    }
    public WysylanieWiadomosciGUI(Klient klient, Wiadomosc wiad, Color color) {
        this.klient = klient;
        setContentPane(wysylanieWiadomosci);
        Odbiorca.setText(wiad.getNadawca());
        Temat.setText("Re:"+wiad.getTemat());
        wiad.setTemat("Re:"+wiad.getTemat());

        if(color==Color.darkGray){
            Odbiorca.setBackground(Color.darkGray);
            tekstWiadomosci.setBackground(Color.darkGray);
            Temat.setBackground(Color.darkGray);
            wyslijWiadomoscButton.setBackground(Color.darkGray);
            anulujButton.setBackground(Color.darkGray);
            wysylanieWiadomosci.setBackground(Color.darkGray);
            odbiorcaText.setBackground(Color.darkGray);
            tematText.setBackground(Color.darkGray);
            tlo.setBackground(Color.darkGray);
            Odbiorca.setForeground(Color.white);
            tekstWiadomosci.setForeground(Color.white);
            Temat.setForeground(Color.white);
            wyslijWiadomoscButton.setForeground(Color.white);
            anulujButton.setForeground(Color.white);
            wysylanieWiadomosci.setForeground(Color.white);
            odbiorcaText.setForeground(Color.white);
            tematText.setForeground(Color.white);
            tlo.setForeground(Color.white);
            tlo2.setBackground(Color.darkGray);
        }

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        wyslijWiadomoscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Wiadomosc wiadomosc = new Wiadomosc("mail", Odbiorca.getText(), klient.getBazaDanych().getAktualneKonto().getEmail(), Temat.getText(), tekstWiadomosci.getText());
                    klient.wyslij(wiadomosc);
                    dispose();
                } catch (Exception f) {
                    System.out.println("BLAD WYSYŁANIA WIADOMOŚCI");
                    JOptionPane.showMessageDialog(wysylanieWiadomosci, "Błąd wysyłania wiadomości");
                    dispose();
                }
            }
        });

    }

}


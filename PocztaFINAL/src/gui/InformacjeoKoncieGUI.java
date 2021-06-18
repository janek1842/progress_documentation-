package gui;

import poczta.Klient;
import poczta.Konto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformacjeoKoncieGUI extends JFrame {
    private JPanel informacjeoKoncie;
    private JTextField email;
    private JTextField nazwisko;
    private JTextField emailZapasowy;
    private JTextField nazwa;
    private JLabel haslotext;
    private JPasswordField hasloText;
    private JButton zatwierdźZmianyButton;
    private JButton anulujButton;
    private JLabel emailText;
    private JLabel emailZapText;
    private JLabel nazwaText;
    private JLabel nazwiskoText;
    private String haslo;


    public InformacjeoKoncieGUI(Klient klient, Color color) {
        setContentPane(informacjeoKoncie);
        informacjeoKoncie.setBackground(color);
        if(color==Color.darkGray)
        {
            informacjeoKoncie.setForeground(Color.white);
            email.setForeground(Color.white);
            emailZapasowy.setForeground(Color.white);
            nazwa.setForeground(Color.white);
            nazwisko.setForeground(Color.white);
            hasloText.setForeground(Color.white);
            anulujButton.setForeground(Color.white);
            zatwierdźZmianyButton.setForeground(Color.white);
            emailText.setForeground(Color.white);
            emailZapText.setForeground(Color.white);
            nazwaText.setForeground(Color.white);
            nazwiskoText.setForeground(Color.white);
            haslotext.setForeground(Color.white);
        }
        email.setText(klient.getBazaDanych().getAktualneKonto().getEmail());
        email.setBackground(color);
        emailZapasowy.setText(klient.getBazaDanych().getAktualneKonto().getEmailZapasowy());
        emailZapasowy.setBackground(color);
        nazwa.setText(klient.getBazaDanych().getAktualneKonto().getNazwa());
        nazwa.setBackground(color);
        nazwisko.setText(klient.getBazaDanych().getAktualneKonto().getNazwisko());
        nazwisko.setBackground(color);
        hasloText.setText(klient.getBazaDanych().getAktualneKonto().getHaslo());
        hasloText.setBackground(color);
        anulujButton.setBackground(color);
        zatwierdźZmianyButton.setBackground(color);

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        zatwierdźZmianyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                haslo=JOptionPane.showInternalInputDialog(informacjeoKoncie,"Wprowadź stare hasło!");
                if(haslo.equals(klient.getBazaDanych().getAktualneKonto().getHaslo())){
                    Konto konto = new Konto(nazwa.getText(),nazwisko.getText(),email.getText(),new String(hasloText.getPassword()),emailZapasowy.getText(),klient.getBazaDanych().getAktualneKonto().getKluczSzyfrowania());
                    //TODO: moze lepiej na zapisywac hasla na kliencie?
                    klient.getBazaDanych().getAktFolderKonta().zapiszKonto(konto);
                    klient.wyslij(konto,"zmienInfo");
                    JOptionPane.showMessageDialog(informacjeoKoncie,"Dane konta zostały zmienione poprawnie");
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(informacjeoKoncie,"Błędne hasło ! ");
                }

            }
        });
    }
}

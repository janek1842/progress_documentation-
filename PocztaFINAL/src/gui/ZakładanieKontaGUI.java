package gui;

import poczta.Klient;
import poczta.Konto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZakładanieKontaGUI extends JFrame {
    private JTextField nazwa;
    private JTextField Nazwisko;
    private JTextField Email;
    private JTextField EmailZap;
    private JTextField Haslo;
    private JButton załóżKontoButton;
    private JButton anulujButton;
    private JPanel PanelZakladanieKonta;
    private Klient klient;
    private Konto konto;

    public ZakładanieKontaGUI(Klient klient)  {
        this.klient = klient;
        setContentPane(PanelZakladanieKonta);

        załóżKontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    konto = new Konto(nazwa.getText(), Nazwisko.getText(), Email.getText(), Haslo.getText(), EmailZap.getText());
                    klient.wyslij(konto, "zalozKonto");
                    klient.getWydarzenie().przerwijGdy("dodawanieKonta_response");
                    if (klient.getWydarzenie().getWartosc2().equals("dodajKontoTrue"))
                    {
                        dispose();
                    }
                    else {
                        System.out.println("BLAD REJESTRACJI");
                        JOptionPane.showMessageDialog(PanelZakladanieKonta, "Błędne dane rejestracji");
                        dispose();
                    }
                }
                catch (Exception g)
                {
                    System.out.println("BLAD REJESTRACJI");
                    JOptionPane.showMessageDialog(PanelZakladanieKonta, "Błędne dane rejestracji");
                    dispose();
                }
            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {

    }
}

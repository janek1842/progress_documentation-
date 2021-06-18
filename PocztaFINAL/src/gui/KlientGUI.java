package gui;

import poczta.Klient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class KlientGUI extends JFrame{
    private JPanel panelGlowny;
    private JPanel panelGorny;
    private JPanel panelDolny;
    private JButton zalogujButton;
    private JButton zalozKontoButton;
    private JLabel napisGorny;
    private JTextField emailText;
    private JPasswordField hasloText;

    private JRadioButton zapamiętajEmailIHasłoRadioButton;
    // private JTextField hasloText;
    private Klient klient = new Klient("localhost",2300); // na sztywno
    public KlientGUI() {
        if(klient.getBazaDanych().getAktualneKonto() != null)
        {
            emailText.setText(klient.getBazaDanych().getAktualneKonto().getEmail());
            hasloText.setText(klient.getBazaDanych().getAktualneKonto().getHaslo());
        }
        JFrame ekranStartowy = new JFrame("poczta.Klient");
        ekranStartowy.setContentPane(panelGlowny);
        ekranStartowy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ekranStartowy.setVisible(true);
        ekranStartowy.pack();

        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(klient.zaloguj(emailText.getText(),String.valueOf(hasloText.getPassword()))){
                    //System.out.println("zalogowano na konto " + emailText.getText());
                    // otworz nastepne okno
                    OknoGlowneGUI oknoGlowneGUI = new OknoGlowneGUI(klient,zapamiętajEmailIHasłoRadioButton);
                   // oknoGlowne.setVisible(true);
                    ekranStartowy.setVisible(false);
                   // ekranStartowy.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    dispose();
                }
                else {
                    System.out.println("bledne dane logowania");
                    emailText.setText("");
                    hasloText.setText("");
                    JOptionPane.showMessageDialog(panelGlowny, "Błędne dane logowania");
                }
            }
        });
        zalozKontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new ZakładanieKontaGUI(klient);
               f.pack();
               f.setVisible(true);
            }
        });

        zapamiętajEmailIHasłoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public KlientGUI(Klient kliencik) {
        JFrame ekranStartowy = new JFrame("poczta.Klient");
        ekranStartowy.setContentPane(panelGlowny);
        ekranStartowy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ekranStartowy.setVisible(true);
        ekranStartowy.pack();
        emailText.setText(kliencik.getBazaDanych().getAktualneKonto().getEmail());
        hasloText.setText(kliencik.getBazaDanych().getAktualneKonto().getHaslo());

        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(klient.zaloguj(emailText.getText(),new String(hasloText.getPassword()))){
                    //System.out.println("zalogowano na konto " + emailText.getText());
                    // otworz nastepne okno
                    OknoGlowneGUI oknoGlowneGUI = new OknoGlowneGUI(klient,zapamiętajEmailIHasłoRadioButton);
                    // oknoGlowne.setVisible(true);
                    ekranStartowy.setVisible(false);
                    // ekranStartowy.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    dispose();
                }
                else {
                    System.out.println("bledne dane logowania");
                    emailText.setText("");
                    hasloText.setText("");
                    JOptionPane.showMessageDialog(panelGlowny, "Błędne dane logowania");
                }
            }
        });
        zalozKontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new ZakładanieKontaGUI(klient);
                f.pack();
                f.setVisible(true);
            }
        });

        zapamiętajEmailIHasłoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }


    public static void main(String[] args) {
        KlientGUI klientGUI = new KlientGUI();
        klientGUI.klient.getWydarzenie().przerwijGdyWpisano("x"); //wcisnij po zalogowaniu
        klientGUI.klient.wyloguj();
        klientGUI.klient.zapiszBaze();
    }

    public JRadioButton getZapamiętajEmailIHasłoRadioButton() {
        return zapamiętajEmailIHasłoRadioButton;
    }
}

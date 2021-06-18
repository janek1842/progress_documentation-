package gui;

import poczta.Klient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZmianaHaslaGUI extends JFrame {
    private JButton akceptujButton;
    private JButton anulujButton;
    private JPasswordField stareHaslo;
    private JPasswordField noweHaslo;
    private JPanel ZmianaHaslaGUI;

    public ZmianaHaslaGUI(Klient klient) {
        setContentPane(ZmianaHaslaGUI);
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        akceptujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(klient.getBazaDanych().getAktualneKonto().getHaslo().equals(new String(stareHaslo.getPassword()))) {
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(ZmianaHaslaGUI, "Błędne dane!");
                    dispose();
                }
            }
        });
    }
}

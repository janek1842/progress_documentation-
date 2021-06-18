package gui;

import poczta.Klient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogowanieGUI extends JFrame{
    private JTextField emailText;
    private JPasswordField hasloText;
    private JPanel PanelGlowny;
    private JButton zalogujButton;
    private JButton anulujButton;
    private Klient klient;

    public LogowanieGUI(Klient klient) {
       setContentPane(PanelGlowny);
       this.klient = klient;

        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Logowanie");
        //frame.setContentPane(new LogowanieGUI().PanelGlowny);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

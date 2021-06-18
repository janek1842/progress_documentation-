package Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class formularz extends JFrame {
    private JTextField Nrejestr;
    private JTextField Model;
    private JTextField Maxobroty;
    private JRadioButton a5BiegówManualnaRadioButton;
    private JRadioButton a6BiegówManualnaRadioButton;
    private JRadioButton dieselRadioButton;
    private JRadioButton benzynaRadioButton;
    private JTextField Predkoscmax;
    private JButton dodajButton;
    private JButton anulujButton;
    private JPanel formularz;
    private Sprzeglo spr;
    private SkrzyniaBiegow skr;
    private Silnik sil;

    public formularz(JComboBox comboBox) throws HeadlessException {

        spr = new Sprzeglo("spr", 40, 60, true);
        skr = new SkrzyniaBiegow("skrz1", 50, 50, 5, spr, 100);
        sil = new Silnik("S1", 10, 60, 1000);

        setContentPane(formularz);

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new formularz(comboBox);
                if(a5BiegówManualnaRadioButton.isSelected()){
                    skr.setIloscBiegow(5);
                }
                if(a6BiegówManualnaRadioButton.isSelected()) {
                    skr.setIloscBiegow(6);
                }
                if(benzynaRadioButton.isSelected()){
                    sil.setNazwa("Benzyna");
                }
                if(dieselRadioButton.isSelected()){
                    sil.setNazwa("Diesel");
                }
                sil.setMaxobroty(Double.parseDouble(Maxobroty.getText()));
                comboBox.addItem(new Samochod(Nrejestr.getText(),Model.getText(),Double.parseDouble(Predkoscmax.getText()),sil,skr,spr));
                dispose();
            }
        });
    }
}

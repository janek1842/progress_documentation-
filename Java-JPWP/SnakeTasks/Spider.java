package Zadanie3;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spider extends JPanel {
    static final int width = 500;
    static final int height = 500;
    boolean running = false;
    int eyeX = width/2-20, eyeY = height/2-20;

    public Spider(){
        JButton btn = new JButton("START/STOP");
        int btnWidth = 100;
        int btnHeight = 20;
        btn.setBounds(width/2-btnWidth/2-10,height/2+100,btnWidth,btnHeight);

        Timer timer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*
                * tutaj zrobić żeby oczka szły w prawo lub w lewo
                */

                if(running) {

                    eyeX += 20;
                    eyeY += 20;

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }

                    eyeY -= 20;
                    eyeX -= 20;

                }

            }
        });

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(running){
                    timer.stop();
                    running = false;
                }
                else{
                    timer.start();
                    running = true;
                }
            }
        });

        this.add(btn);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);

        if(running){
            drawEyes(g);
        }
    }

    void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        int circleSize = 100;
        g2d.fillOval((width - circleSize) / 2, (width - circleSize) / 2, circleSize, circleSize);

        int centerX = width / 2;
        int centerY = height / 2;
        int lineLength = 80;

        /*
        * dorysować nogi
        * */

        super.paintComponent(g);
        g.drawLine(0,0,20,20);
        g.drawLine(0,0,30,30);
        g.drawLine(0,0,40,40);
        g.drawLine(0,0,50,50);
        g.drawLine(0,0,60,60);
        g.drawLine(0,0,70,70);

        drawEyes(g);
    }

    void drawEyes(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        int eyeSize = 10;
        int eyeSpace = 15;
        g2d.fillOval(eyeX, eyeY, eyeSize, eyeSize);
        g2d.fillOval(eyeX+eyeSpace, eyeY, eyeSize, eyeSize);
    }

    public static void main(String[] args) {
        Spider spider = new Spider();
        JFrame app = new JFrame("Pajączek");
        app.add(spider, BorderLayout.CENTER);
        app.setSize(width, height);
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
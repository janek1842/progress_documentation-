package Zadania1_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {

    static final int width = 600;
    static final int height = 600;
    static final int unit_size = 25;
    static final int units = (width*height)/unit_size;
    static final int delay = 50;
    final int x[] = new int[units];
    final int y[] = new int[units];
    int body_parts = 6;
    int candies_eaten;
    int candyX;
    int candyY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;


    Panel(){

        random = new Random();
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        start();

    }

    public void start(){
        //************************************************************
        //************************************************************
        // tutaj nalezy uzupełnić metodę start()
        //************************************************************
        //************************************************************
        addCandy();
        running= true;
        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        draw(graphics);
    }

    public void draw(Graphics graphics){
        if(running) {
            for (int i = 0; i < width / unit_size; i++) {
                graphics.drawLine(i * unit_size, 0, i * unit_size, height);
                graphics.drawLine(0, i * unit_size, width, i * unit_size);
            }
            graphics.setColor(Color.red);
            graphics.fillOval(candyX, candyY, unit_size, unit_size);

            for (int i = 0; i < body_parts; i++) {
                if (i == 0) {
                    graphics.setColor(new Color(0,150,50));
                    graphics.fillRect(x[i], y[i], unit_size, unit_size);
                } else {
                    graphics.setColor(Color.green);
                    graphics.fillRect(x[i], y[i], unit_size, unit_size);
                }
            }
            graphics.setColor(Color.PINK);
            graphics.setFont(new Font("Calibri", Font.BOLD, 30));
            FontMetrics metrics = getFontMetrics(graphics.getFont());
            graphics.drawString("Score: "+candies_eaten, 10, 30);

        }
        else{
            gameOver(graphics);
        }
    }

    public void addCandy(){
        candyX = random.nextInt((int)(width/unit_size))*unit_size;
        candyY = random.nextInt((int)(height/unit_size))*unit_size;
        for(int i=0; i<body_parts; i++){
            if(candyX == x[i] && candyY == y[i]){
                addCandy();
                break;
            }
        }
    }

    public void move(){
        //************************************************************
        //************************************************************
        // tutaj nalezy uzupełnić metodę move()
        //************************************************************
        //************************************************************
    }

    public void checkCandy(){
        if(x[0] == candyX && y[0] == candyY){
            body_parts++;
            candies_eaten++;
            addCandy();
        }
    }

    public void checkCollisions(){
        for(int i=body_parts;i>0;i--){
            if(x[0] == x[i] && y[0] == y[i]){
                running = false;
            }
        }
        if(x[0] < 0){
            running = false;
        }
        if(x[0] > width){
            running = false;
        }
        if(y[0] < 0){
            running = false;
        }
        if(y[0] > height){
            running = false;
        }
        if(!running){
            timer.stop();
        }
    }

    public void gameOver(Graphics graphics){
        graphics.setColor(Color.red);
        graphics.setFont(new Font("Calibri", Font.BOLD, 75));
        FontMetrics metrics1 = getFontMetrics(graphics.getFont());
        graphics.drawString("Game Over", (width - metrics1.stringWidth("Game Over"))/2, height/2);

        graphics.setColor(Color.PINK);
        graphics.setFont(new Font("Calibri", Font.BOLD, 50));
        FontMetrics metrics2 = getFontMetrics(graphics.getFont());
        graphics.drawString("Score: "+candies_eaten, (width - metrics2.stringWidth("Score: "+candies_eaten))/2, (height/2)+50);

        this.add(Frame.btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            checkCandy();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()){
                //************************************************************
                //************************************************************
                // tutaj nalezy uzupełnić klasę MyKeyAdapter
                //************************************************************
                //************************************************************
            }
        }
    }
}

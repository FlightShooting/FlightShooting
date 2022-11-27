package com.example.aviones.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
public class VentanaAvion extends JFrame implements Runnable {
    int x1, x2;

    public VentanaAvion() {
        x1 = x2 = 10;
        initFrame();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Image k=Toolkit.getDefaultToolkit().getImage("C:\\Users\\cbocc\\Documents\\GitHub\\FlightShooting\\aviones\\png\\field.png");
        g.drawImage(k, 0, 0, 900, 900, this);
        g.setColor(Color.RED);
        g.drawLine(50, 0, 50, 800);
        Font f=new Font("Ariel Black", Font.BOLD, 20);
        g.setFont(f);
        g.drawString("EMPEZAR", 50, 50);
        g.setColor(Color.BLUE);
        g.drawLine(800, 0, 800, 800);
        Image j=Toolkit.getDefaultToolkit().getImage("C:\\Users\\cbocc\\Documents\\GitHub\\FlightShooting\\aviones\\png\\plane.png");
        g.drawImage(j, 600, 110, 40, 50, this);
        g.drawImage(j, 600, 310, 40, 50, this);
        g.drawImage(j, 600, 510, 40, 50, this);
        g.drawImage(j, 600, 710, 40, 50, this);
    }
    private void initFrame() {
        this.setTitle("Flight Race");
        this.setSize(900, 900);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void avion1(){
        while(x1!=800) {
            x1++;
            repaint();
        }
    }

    private void avion2() {
        while(x2!=800) {
            x2++;
            repaint();
            }
        }



    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("avion1")) {
                avion1();
        }
        else if(Thread.currentThread().getName().equals("avion2")) {
                avion2();
        }

    }
}

package com.example.aviones.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class Ventana extends JFrame implements Runnable {
    int x1, x2;
    JButton boton;

    public Ventana() {
        x1 = x2 = 10;
        initFrame();
    }
    @Override
    public void paint(Graphics g) {
        boton = new JButton("EMPEZAR");
        boton.setBounds(20, 10, 100, 30);
        add(boton);
        super.paint(g);
        Image k=Toolkit.getDefaultToolkit().getImage("C:\\Users\\cbocc\\Documents\\GitHub\\FlightShooting\\aviones\\png\\field.jpeg");
        g.drawImage(k, 0, 0, 2500, 1000, this);
        Font f=new Font("Ariel Black", Font.BOLD, 20);
        g.setFont(f);

        Image j=Toolkit.getDefaultToolkit().getImage("C:\\Users\\cbocc\\Documents\\GitHub\\FlightShooting\\aviones\\png\\plane.png");
        g.drawImage(j, 450, 110, 40, 50, this);
        g.drawImage(j, 100, 110, 40, 50, this);
    }
    private void initFrame() {
        this.setTitle("Persecución de aviones");
        this.setSize(2500, 1000);
        this.setSize(900, 900);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
    }
    private void avion(){
        while(x1!=800) {
            x1++;
            repaint();
        }
    }

    private void avionPerseguidor() {
        while(x2!=800) {
            x2++;
            repaint();
            }
        }



    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("avion")) {
                avion();
        }
        else if(Thread.currentThread().getName().equals("avionPerseguidor")) {
                avionPerseguidor();
        }

    }
}

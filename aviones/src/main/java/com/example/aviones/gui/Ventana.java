package com.example.aviones.gui;

import javax.swing.*;

public class Ventana {

    private JPanel flight;
    private JList datos;
    private JButton JUGARButton;

    public Ventana() {
        JFrame frame = new JFrame("Flight Simulator");
        frame.setContentPane(flight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}

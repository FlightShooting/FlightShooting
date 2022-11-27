package com.example.aviones.lanzador;

import com.example.aviones.avion.Avion;
import com.example.aviones.avion.AvionPerseguidor;
import com.example.aviones.gui.Ventana;

import java.util.Scanner;

public class Lanzador {
    public static void lanzar() {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la altura del avión: ");
        int altura = scanner.nextInt();
        System.out.println("Introduce la velocidad del avión: ");
        int velocidad = scanner.nextInt();

        AvionPerseguidor perseguidor = new AvionPerseguidor(altura, velocidad, Avion.Direccion.IZQUIERDA);
        Avion avion = new Avion(altura-1000, velocidad-100, Avion.Direccion.DERECHA);
        avion.addObserver(perseguidor);

        avion.subir();
        avion.bajar();
        avion.bajar();
        avion.girar(Avion.Direccion.IZQUIERDA);
        avion.girar(Avion.Direccion.DERECHA);
        avion.acelerar();

        System.out.println();
        System.out.println("Altura perseguidor " + perseguidor.getAltura());
        System.out.println("Velocidad perseguidor " + perseguidor.getVelocidad());
        System.out.println("Dirección perseguidor " + perseguidor.getDireccion().toString());
    }
}

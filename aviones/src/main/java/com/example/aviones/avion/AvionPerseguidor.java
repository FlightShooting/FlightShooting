package com.example.aviones.avion;


import java.util.Observable;
import java.util.Observer;

public class AvionPerseguidor extends Avion implements Observer {

    public AvionPerseguidor(int altura, int velocidad, Direccion direccion) {
        super(altura, velocidad, direccion);
    }

    @Override
    public void update(Observable o, Object arg) {

        Accion accion = (Accion) arg;
        switch (accion) {
            case SUBIR:
                subir();
                System.out.println("El perseguidor sube");
                break;
            case BAJAR:
                bajar();
                System.out.println("El perseguidor baja");
                break;
            case ACELERAR:
                acelerar();
                System.out.println("El perseguidor acelera");
                break;
            case FRENAR:
                frenar();
                System.out.println("El perseguidor frena");
                break;
            case GIRAR:
                girar(((Avion) o).getDireccion());
                System.out.println("El perseguidor gira");
                break;
            default:
        }
    }
}

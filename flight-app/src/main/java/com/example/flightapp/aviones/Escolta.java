package com.example.flightapp.aviones;

public class Escolta extends Avion implements Runnable {

    public Escolta(String id, int velocidad, int recorrido) {
        super(id, velocidad, recorrido);
    }

    @Override
    public void run() {

    }
}

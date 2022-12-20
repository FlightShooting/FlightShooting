package com.example.flightapp.aviones;

public class Escolta implements Runnable {
        private String ruta;

    public void update(String rutas) {
        this.ruta = rutas;
        run();
    }

    @Override
    public void run() {

    }




}

package com.example.flightapp.aviones;

public class Escolta implements Runnable {
    private double ruta;
    private String id;

    public void update(String id, double ruta) {
        this.ruta = ruta;
        this.id = id;
        run();
    }
    @Override
    public void run() {
        System.out.println("Avión escolta para vuelo #" + id +  " despegando . . .");
    }
}

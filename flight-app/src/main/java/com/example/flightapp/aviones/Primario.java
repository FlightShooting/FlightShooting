package com.example.flightapp.aviones;

import com.example.flightapp.controller.TorreControl;

import java.util.Random;
import java.lang.Thread;

public class Primario implements Runnable {
    private String id;
    //velocidad de un vuelo comercial
    private int velocidad = 860;

    private int altura;

    private double distancia;
    private String origen;
    private String destino;
    private String CodOrig;
    private String CodDest;
    private double lat1;
    private double lng1;
    private double lat2;
    private double lng2;

    private String[] Codigos;

    @Override
    public void run() {
        //se genera un identificador de vuelo
        genIdentificador();
        //primero se obtiene un plan de vuelo
        plan();
        //luego se obtiene la ruta
        ruta(lat1, lng1, lat2, lng2);
        //empezar vuelo
        vuelo();
        notificarTorre(/*rutas*/);
    }

    private void genIdentificador() {
        Random random = new Random();
        int num = random.nextInt(1000);
        this.id = String.format("%03d", num);
        System.out.println("El vuelo: #" + id + " se prepara para partir");
    }

    private void notificarTorre(/*rutas*/) {
        TorreControl observable = new TorreControl();
        Escolta observer = new Escolta();
        observable.addEscolta(observer);
        //observable.setRutas(/*rutas*/);

    }

    //este metodo tarda en ejecutarse lo que representa el tiempo que tarda en realizarse el vuelo
    private void vuelo() {
        System.out.println("El vuelo: " + id + " con origen " + this.origen + " y destino " + this.destino + " esta despegando . . .");
        //calcular tiempo de vuelo restante y mostrarlo
        double progreso = 100.0; // the distance you want to represent as a percentage
        double totalDistance = distancia; // the total distance

        double percentage = (progreso / totalDistance) * 100.0; // calculate the percentage
        System.out.println("Progreso del vuelo:");
        boolean volando = true;
        while (volando){
            System.out.println(percentage + "% . . .");
            thread
            if ()
        }

        //notificar cuando se llegue a destino
        System.out.println("El avion " + id + " ha llegado a su destino");
    }

    private void plan() {
        //crear plan de vuelo estableciendo origen y destino
        boolean iguales = true;
        int ori = 0;
        int des = 0;
        //generar numero aleatorio para el id entre 1 y 5
        while (iguales) {
            ori = (int) (Math.random() * 5 + 1);
            des = (int) (Math.random() * 5 + 1);
            if (ori != des) {
                iguales = false;
            }
        }

        switch (ori) {
            case 1:

                this.CodOrig = "LEMD";
                this.origen = "Madrid-Barajas";
                this.lat1 = 40.471926;
                this.lng1 =-3.56264;

                break;
            case 2:
                this.CodOrig = "LEBL";
                this.origen = "Barcelona-El Prat";
                this.lat1 = 41.297078;
                this.lng1 = 2.078464;
                break;
            case 3:
                this.CodOrig = "EGLL";
                this.origen = "Londres-Heathrow";
                this.lat1 = 41.297078;
                this.lng1 = 2.078464;

                break;
            case 4:
                this.CodOrig = "EHAM";
                this.origen = "Amsterdam-Schiphol";
                this.lat1 = 52.308613;
                this.lng1 = 4.763889;

                break;
            case 5:
                this.CodOrig = "LFPG";
                this.origen = "Paris-Charles de Gaulle";
                this.lat1 = 49.012798;
                this.lng1 = 2.55;

                break;
        }
        switch (des) {
            case 1:
                this.CodDest = "LEMD";
                this.destino = "Madrid-Barajas";
                this.lat2 = 40.471926;
                this.lng2 = -3.56264;
                break;
            case 2:
                this.CodDest = "LEBL";
                this.destino = "Barcelona-El Prat";
                this.lat2 = 41.297078;
                this.lng2 = 2.078464;
                break;
            case 3:
                this.CodDest = "EGLL";
                this.destino = "Londres-Heathrow";
                this.lat2 = 41.297078;
                this.lng2 = 2.078464;
                break;
            case 4:
                this.CodDest = "EHAM";
                this.destino = "Amsterdam-Schiphol";
                this.lat2 = 52.308613;
                this.lng2 = 4.763889;
                break;
            case 5:
                this.CodDest = "LFPG";
                this.destino = "Paris-Charles de Gaulle";
                this.lat2 = 49.012798;
                this.lng2 = 2.55;
                break;
        }
    }

    public void ruta(double lat1, double lng1, double lat2, double lng2) {
        //calcular ruta para llegar de A a B
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        this.distancia = 6371 * va2;
        //
        System.out.println(distancia);
        //calcular tiempo de vuelo
        double tiempo = distancia / velocidad;
        System.out.println("ETA: " + tiempo + "hrs.");
    }
}

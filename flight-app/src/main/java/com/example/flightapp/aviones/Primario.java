package com.example.flightapp.aviones;

import com.example.flightapp.controller.TorreControl;

import java.time.Duration;
import java.util.Date;

public class Primario implements Runnable {
    private String id;
    //velocidad de un vuelo comercial
    private int velocidad = 740;

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
    private double tiempo;

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
        notificarLlegada();
    }

    private void notificarLlegada() {
        TorreControl observable = new TorreControl();
        Escolta observer = new Escolta();
        observable.removeEscolta(observer);
    }

    private void genIdentificador() {
        //genera in identificador para el vuelo con la fecha de salida en hexadecimal
        Date fechaActual = new Date();
        this.id = Long.toHexString(fechaActual.getTime());
        System.out.println("El vuelo: #" + id + " se prepara para partir");
    }

    private void notificarTorre(/*rutas*/) {
        TorreControl observable = new TorreControl();
        Escolta observer = new Escolta();
        observable.addEscolta(observer);
        observable.setRutas(id, distancia);
    }

    //este metodo tarda en ejecutarse lo que representa el tiempo que tarda en realizarse el vuelo
    private void vuelo() {
        System.out.println("El vuelo: #" + id + " con origen " + this.origen + " y destino " + this.destino + " esta despegando . . .");
        //notifica a la torre de control
        notificarTorre();
        //calcular tiempo de vuelo restante y mostrarlo
        System.out.println("Progreso del vuelo:");
        double progreso = 0; //porcentage de veulo completado
        boolean volando = true;

        while (volando) {

            System.out.printf("%.2f", progreso);
            System.out.println("% . . .");
            double incremento = (1 + (velocidad / distancia));
            progreso = progreso + incremento;
            if (progreso > 100.0) {
                System.out.println("100.00%");
                volando = false;
            }
            try {
                Thread.sleep(10); // Espera por un segundo
            } catch (InterruptedException e) {
                // Maneja la excepción
            }

        }
        //notificar cuando se llegue a destino
        System.out.printf("El vuelo #%s ha llegado a su destino en %.2f horas. ",id , tiempo);
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
        //calcular ruta para llegar de A a B y tiempo
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        this.distancia = 6371 * va2;
        this.tiempo = distancia / velocidad;
        //calcular tiempo de vuelo aproximado
        System.out.printf("ETA: %.2f hrs. ", tiempo);
        System.out.println("");
    }
}
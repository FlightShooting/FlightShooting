package com.example.flightapp.aviones;

public class primario implements Runnable {
    String id;
    int velocidad;

    @Override
    public void run() {
        //primero se obtiene un plan de vuelo
        plan();
        //luego se obtiene la ruta
        ruta();
        //empezar vuelo
        vuelo(velocidad, id);
    }

    //este metodo tarda en ejecutarse lo que representa el tiempo que tarda en realizarse el vuelo
    private void vuelo(int v, String id) {
        //calcular tiempo de vuelo restante y mostrarlo
        //notificar cuando se llegue a destino
        System.out.println("El avion " + id + " ha llegado a su destino");
    }

    private void plan() {
        //crear plan de vuelo estableciendo origen y destino
        char origen = 'A';
        char destino = 'B';
    }

    public void ruta(){
        //obtener cordenadas desde api, obtener cordenadas de A y B
        int origenX, origenY, destinoX, destinoY;
        //calcular ruta para llegar de A a B
    }
}

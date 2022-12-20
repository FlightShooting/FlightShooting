package com.example.flightapp.controller;

import com.example.flightapp.aviones.Escolta;

import java.util.ArrayList;
import java.util.List;

public class TorreControl {
        private double rutas;
        private List<Escolta> avion = new ArrayList<>();

        public void addEscolta(Escolta avion){
                this.avion.add(avion);
        }

        public void removeEscolta(Escolta avion){
                this.avion.remove(avion);
                System.out.println("El avión escolta ha terminado su seguimineto.");
        }

        public void setRutas(String id, double distancia){
                this.rutas = distancia;
                for (Escolta avion : this.avion){
                        avion.update(id,this.rutas);
                }
        }

}

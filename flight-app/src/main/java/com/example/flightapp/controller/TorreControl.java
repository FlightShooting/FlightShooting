package com.example.flightapp.controller;

import com.example.flightapp.aviones.Escolta;

import java.util.ArrayList;
import java.util.List;

public class TorreControl {
        private String rutas;
        private List<Escolta> avion = new ArrayList<>();

        public void addEscolta(Escolta avion){
                this.avion.add(avion);
        }

        public void removeEscolta(Escolta avion){
                this.avion.remove(avion);
        }

        public void setRutas(String rutas){
                this.rutas = rutas;
                for (Escolta avion : this.avion){
                        avion.update(this.rutas);
                }
        }

}

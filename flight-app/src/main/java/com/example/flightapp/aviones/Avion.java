package com.example.flightapp.aviones;

public abstract class Avion {
    protected String id;
    protected int velocidad, recorrido;

  public Avion(String id, int velocidad, int recorrido){
      this.id = id;
      this.velocidad = velocidad;
      this.recorrido = recorrido;
  }
}

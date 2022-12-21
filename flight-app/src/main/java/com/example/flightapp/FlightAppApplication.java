package com.example.flightapp;

import com.example.flightapp.apicontroller.AirportController;
import com.example.flightapp.aviones.Escolta;
import com.example.flightapp.aviones.Primario;
import com.example.flightapp.controller.TorreControl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Random;

@SpringBootApplication
public class FlightAppApplication {


    public static void main(String[] args) {
        /*AirportController airportController = new AirportController();
        airportController.conectar();*/
        System.out.println("--SE ABRE EL TRAFICO AEREO--");
       Primario p = new Primario();
       p.run();

    }

}

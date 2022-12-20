package com.example.flightapp;

import com.example.flightapp.aviones.Escolta;
import com.example.flightapp.aviones.Primario;
import com.example.flightapp.controller.TorreControl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FlightAppApplication {


    public static void main(String[] args) throws IOException {

       SpringApplication.run(FlightAppApplication.class, args);
       Primario p = new Primario( "1", 100, 1000);
       p.run();
    }

}

package com.example.flightapp;

import com.example.flightapp.aviones.Primario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightAppApplication.class, args);
        Primario p = new Primario();
        p.run();
    }

}

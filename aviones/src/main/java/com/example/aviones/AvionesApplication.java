package com.example.aviones;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.aviones.lanzador.Lanzador.lanzar;

@SpringBootApplication
public class AvionesApplication {

	public static void main(String[] args) {
		lanzar(args);
	}

}

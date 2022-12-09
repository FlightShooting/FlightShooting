package com.example.flightapp.aviones;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.writer.JsonReader;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;

import java.io.*;

public class Primario extends Avion implements Runnable {
    private String origen;
    private String destino;
    private String CodOrig;
    private String CodDest;


    private static final String filePath = "src/main/resources/airports.json";
    //JSONParser parser = new JSONParser();
    //JSONArray a = (JSONArray) parser.parse(new FileReader("src/main/resources/airports.json"));


   ObjectMapper mapper = new ObjectMapper();
   JsonNode airports = mapper.readTree(new File("src/main/resources/airports.json"));

    public Primario(String id, int velocidad, int recorrido) throws IOException {
        super(id, velocidad, recorrido);
    }

    @Override
    public void run() {
        //primero se obtiene un plan de vuelo
        plan();
        //luego se obtiene la ruta
        try {
            ruta();
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
        //empezar vuelo
        vuelo(velocidad, id);
    }

    //este metodo tarda en ejecutarse lo que representa el tiempo que tarda en realizarse el vuelo
    private void vuelo(int v, String id) {
        System.out.println("El vuelo: " + id + " con origen " + this.origen + " y destino " + this.destino + " va a despegar");
        //calcular tiempo de vuelo restante y mostrarlo

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
                break;
            case 2:
                this.CodOrig = "LEBL";
                this.origen = "Barcelona-El Prat";
                break;
            case 3:
                this.CodOrig = "EGLL";
                this.origen = "Londres-Heathrow";
                break;
            case 4:
                this.CodOrig = "EHAM";
                this.origen = "Amsterdam-Schiphol";
                break;
            case 5:
                this.CodOrig = "LFPG";
                this.origen = "Paris-Charles de Gaulle";
                break;
        }
        switch (des) {
            case 1:
                this.CodDest = "LEMD";
                this.destino = "Madrid-Barajas";
                break;
            case 2:
                this.CodDest = "LEBL";
                this.destino = "Barcelona-El Prat";
                break;
            case 3:
                this.CodDest = "EGLL";
                this.destino = "Londres-Heathrow";
                break;
            case 4:
                this.CodDest = "EHAM";
                this.destino = "Amsterdam-Schiphol";
                break;
            case 5:
                this.CodDest = "LFPG";
                this.destino = "Paris-Charles de Gaulle";
                break;
        }
    }

    public void ruta() throws IOException, JSONException {
        //obtener cordenadas desde api
        //JSONObject json = new JSONObject("src/main/resources/airports.json");

        InputStream is = filePath.getClass().getResourceAsStream(filePath);
        String resultado = null;
        JSONObject json = null;
        JSONArray jsonArray = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String linea = null;
        while ((linea = br.readLine()) != null)
            sb.append(linea + "\n");
        is.close();
        resultado = sb.toString();
        json = new JSONObject(resultado);
        jsonArray = json.getJSONArray("features");
        String latitud, longitud,coordenadas = null;
        for (int i = 0; i < jsonArray.length(); i++) {
            latitud = jsonArray.getJSONObject(i).getJSONObject("properties").getString("lat");
            longitud  = jsonArray.getJSONObject(i).getJSONObject("properties").getString("lng");
            coordenadas = coordenadas.substring(1, coordenadas.length() - 1);
            String latlong[] = coordenadas.split(",");
        }


        double lat1 = airports.get(CodOrig).get("lat").asDouble();
        double lon1 = airports.get(CodOrig).get("lng").asDouble();
        double lat2 = airports.get(CodDest).get("lat").asDouble();
        double lon2 = airports.get(CodDest).get("lng").asDouble();
        System.out.println(lat1 + " " + lon1);
        System.out.println(lat2 + " " + lon2);


        //calcular ruta para llegar de A a B
        ordenadorVuelo(lat1,lon1,lat2,lon2);



    }


        public void ordenadorVuelo(double lat1, double lng1, double lat2, double lng2) {
            //calcular ruta para llegar de A a B
            double dLat = Math.toRadians(lat2 - lat1);
            double dLng = Math.toRadians(lng2 - lng1);
            double sindLat = Math.sin(dLat / 2);
            double sindLng = Math.sin(dLng / 2);
            double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                    * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
            double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
            double distancia = 6371 * va2;
            System.out.println(distancia);
            //calcular tiempo de vuelo
            double tiempo = distancia / velocidad;
            System.out.println(tiempo);
            //calcular tiempo de vuelo restante y mostrarlo
            //notificar cuando se llegue a destino
            System.out.println("El avion " + id + " ha llegado a su destino");
        }
        /*
        double radioTierra = 6371;//en kilómetros
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;
        this.recorrido = (int) distancia;
    }

         */
}

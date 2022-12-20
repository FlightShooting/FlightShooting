package com.example.flightapp.services;


import org.springframework.stereotype.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class AirportService {
    public void conectar() {
        //conectar con la API
      //  FirebaseOptions options = new FirebaseOptions.Builder() .setApiKey("AIzaSyC8Cv6m-EMb1WxemWUcuLRxz5lOBpdQHiY") .build();
        //FirebaseApp.initializeApp(options);

        try {
            FileInputStream serviceAccount = new FileInputStream(file);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredential(FirebaseCredentials.fromCertificate("AIzaSyC8Cv6m-EMb1WxemWUcuLRxz5lOBpdQHiY"))
                    .setDatabaseUrl(url)
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: invalid service account credentials. See README.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Shared Database reference
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    }


  //  @GetMapping("/airport")

}

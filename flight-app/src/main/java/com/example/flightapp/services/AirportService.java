package com.example.flightapp.services;


import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.stereotype.Controller;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class AirportService {
    public void conectar() {
        try {
            FirebaseOptions options = new FirebaseOptions.Builder().setApiKey("AIzaSyC8Cv6m-EMb1WxemWUcuLRxz5lOBpdQHiY")
                    .setDatabaseUrl("https://airports-c14a9-default-rtdb.europe-west1.firebasedatabase.app/airports.json")
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

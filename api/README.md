---
description: >-
  En esta página vamos a describir el funcionamiento de la API creada con
  Firebase
---

# API

Pasos que hemos seguido para la creación de la API con firebase:&#x20;

1. Después de haber creado  una cuenta en Firebase hemos creado un RealTime database donde hemos importado el siguiente fichero JSON que hemos previamente creado.&#x20;

Esta acción nos ha generado una URL para proporcionar en un segundo lugar conectividad con la API.

{% hint style="info" %}
[https://airports-c14a9-default-rtdb.europe-west1.firebasedatabase.app/](https://airports-c14a9-default-rtdb.europe-west1.firebasedatabase.app/)
{% endhint %}

```json
{
"airports": [ {
  "code": "LEMD",
  "data": {
    "id": 1,
    "geo": {
      "lat":40.471926,
      "lng":-3.56264
    }   
  }
},
{
  "code":"LEBL",
  "data": {
    "id": 2,
    "geo": {
      "lat":41.297078,
      "lng":2.078464
    }
  }
},
{
  "code":"EGLL",
  "data": {
    "id": 3,
    "geo": {
      "lat":51.470022,
      "lng":-0.454295
    }
  }
},
{
  "code":"EHAM",
  "data": {
    "id": 4,
    "geo": {
      "lat":52.308613,
      "lng":4.763889
    }
  }
},
{
  "code":"LFPG",
  "data": {
    "id": 5,
    "geo": {
      "lat":49.012798,
      "lng":2.55
    }
  }
}
]
}


```

<figure><img src="../.gitbook/assets/codigos.png" alt=""><figcaption><p>Datos almacenados en RealTime Database </p></figcaption></figure>

2\. Despues hemos comprobado que la API funcionase con Postman haciendo un GET, y ese es el resultado devuelto del Postman.

<figure><img src="../.gitbook/assets/postman.png" alt=""><figcaption><p>Captura de Postman</p></figcaption></figure>

3\. Para conectar nuestro código a la API hemos tenido que recuperar la clave publica y eso lo hemos conseguido añadiendo una web app desde la configuración del proyecto. &#x20;

Para eso hemos tenido que configurar el SDK con el siguiente comando

```bash
npm install firebase
```

4\. Desués hemos iniciado a descargar las dependencias:

```xml
        <!-- https://mvnrepository.com/artifact/com.google.firebase/firebase-admin -->
        <dependency>
            <groupId>com.google.firebase</groupId>
            <artifactId>firebase-admin</artifactId>
            <version>9.1.1</version>
            <scope>runtime</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.google.firebase/firebase-database -->
        <dependency>
            <groupId>com.google.firebase</groupId>
            <artifactId>firebase-database</artifactId>
            <version>20.1.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.google.firebase/firebase-firestore -->
        <dependency>
            <groupId>com.google.firebase</groupId>
            <artifactId>firebase-firestore</artifactId>
            <version>24.4.1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework/spring-orm -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>6.0.3</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.google.firebase/firebase-config -->
        <dependency>
            <groupId>com.google.firebase</groupId>
            <artifactId>firebase-config</artifactId>
            <version>21.2.0</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.google.firebase/firebase-encoders-json -->
        <dependency>
            <groupId>com.google.firebase</groupId>
            <artifactId>firebase-encoders-json</artifactId>
            <version>18.0.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.google.firebase/firebase-core -->
        <dependency>
            <groupId>com.google.firebase</groupId>
            <artifactId>firebase-core</artifactId>
            <version>21.1.1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.google.firebase/firebase-auth -->
        <dependency>
            <groupId>com.google.firebase</groupId>
            <artifactId>firebase-auth</artifactId>
            <version>21.1.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.firebase/firebase-client -->
        <dependency>
            <groupId>com.firebase</groupId>
            <artifactId>firebase-client</artifactId>
            <version>2.2.4</version>
            <type>pom</type>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.google.firebase/firebase-server-sdk -->
        <dependency>
            <groupId>com.google.firebase</groupId>
            <artifactId>firebase-server-sdk</artifactId>
            <version>3.0.3</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.google.firebase/firebase-common -->
        <dependency>
            <groupId>com.google.firebase</groupId>
            <artifactId>firebase-common</artifactId>
            <version>20.2.0</version>
        </dependency>

        <dependency>
            <groupId>firebase</groupId>
            <artifactId>bitmap-sdf</artifactId>
            <version>1.0.4</version>
        </dependency>


    </dependencies>
```

Entre las dependencias que nos hemos descargado para la realización de este proyecto podemos destacar: Firebase admin , Firebase client, Firebase authentication, Firebase encoders json, Firebase common, Firebase server, Firebase core, Firebase config, Firebase firestoy y Firebase database.

Despues de habernos descargado las dependencias hemos añadido el siguiente segmento de código Java para permitir la conexión entre Firebase y la aplicación.

```java
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
    private static final String apikey = "AIzaSyC8Cv6m-EMb1WxemWUcuLRxz5lOBpdQHiY";
    private static final String databaseURL = "https://airports-c14a9-default-rtdb.europe-west1.firebasedatabase.app/";
    
    public void conectar() {
        try {
            FirebaseOptions options = new FirebaseOptions.Builder().setApiKey(apikey).setDatabaseUrl(databaseURL).build();
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
}


```

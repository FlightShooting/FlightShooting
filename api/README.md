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

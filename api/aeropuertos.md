---
description: >-
  Aqui vamos a mostrar los pasos para sacar el listado de aeropuertos de la base
  de datos de Firebase, donde hemos almacenado los datos.
---

# Aeropuertos

{% swagger method="get" path="" baseUrl="https://airports-c14a9-default-rtdb.europe-west1.firebasedatabase.app/airports.json" summary="Mostrar un listado de aeropuertos con la longitud y latitud" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-response status="200: OK" description="Aeropuertos devolvidos" %}
```json
[{"code":"LEMD","data":{"geo":{"lat":40.471926,"lng":-3.56264},"id":1}},{"code":"LEBL","data":{"geo":{"lat":41.297078,"lng":2.078464},"id":2}},{"code":"EGLL","data":{"geo":{"lat":51.470022,"lng":-0.454295},"id":3}},{"code":"EHAM","data":{"geo":{"lat":52.308613,"lng":4.763889},"id":4}},{"code":"LFPG","data":{"geo":{"lat":49.012798,"lng":2.55},"id":5}}]
```
{% endswagger-response %}
{% endswagger %}

---
description: Respuestas a las preguntas teóricas
---

# Ejercicios Teoricos

**Pregunta:**

¿Qué código de estado HTTP devolverá una operación que devuelve la lista de usuarios conectados cuando no haya ninguno? ¿Y qué información devolverá en la respuesta?

**Respuesta:**

El código que va devolver una una operación que devuelve la lista de usuarios conectados cuando no haya ninguno, es el código 204, que significa que tendremos resuestas del servidor, porqué la petición es aceptada y procesada, pero no hay contenido. La información que tendremos en la respuesta es que no tenemos acceso a los datos que solicitamos en la petición (Error 403 - Prohibido).

**Pregunta:**

¿Qué código de estado HTTP debe devolver una operación que registra un nuevo producto en la base de datos? ¿Debe devolver algo como respuesta?

**Respuesta:**

El código que nos devuelve una operación que registra un nuevo producto en la base de datos será el siguiente: 201 porque el servidor acepta la petición y la crea. Si debe devolver una respuesta. Si existe un código de estado 201 en un método POST significa que se ha creado un recurso en una API distinta.

**Pregunta:**

¿Qué código de estado HTTP y respuesta devolverá una operación que utiliza el método HTTP DELETE?

**Respuesta:**

Los códigos de estado que puede devolver una operación que utiliza el método HTTP DELETE serán los siguientes: 200 todo ha ido correctamente y la respuesta muestra la descripcion del estado

![html](https://user-images.githubusercontent.com/98779707/203529417-4aa17445-5135-4ff9-8e6c-35bb2ebd3a29.png)

. Luego puede tener el código 204, y 202 donde en la respuesta no se muestra contenido.

**Pregunta:**

¿Qué código de respuesta HTTP devolverá una operación que sirve para conocer la información de un producto determinado? ¿Y si no lo encuentra?

**Respuesta:**

El código de respuesta HTTP que devolverá una operación que sirve para conocer la información de un producto determinado es 206 (Partial Content)Ese código de estado se usa por ejemplo para devolver un rango, producto o página. Si el producto buscado no se encuentra devolverá un error tipo: 404 (Not Found).

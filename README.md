# Flight Shooting

### Ejercicios teóricos
¿Qué código de estado HTTP devolverá una operación que devuelve la lista de usuarios conectados cuando no haya ninguno? ¿Y qué información devolverá en la respuesta?
### Respuesta:
El código que va devolver una una operación que devuelve la lista de usuarios conectados cuando no haya ninguno, es el  código 204, que significa que tendremos resuestas del servidor, porqué la petición es aceptada y procesada, pero no hay contenido. La información que tendremos en la respuesta es que no tenemos acceso a los datos que solicitamos en la petición (Error 403 - Prohibido). 

¿Qué código de estado HTTP debe devolver una operación que registra un nuevo producto en la base de datos? ¿Debe devolver algo como respuesta?
### Respuesta:
El código que nos devuelve una operación que registra un nuevo producto en la base de datos será el siguiente: 201 porque el servidor acepta la petición y la crea. Si debe devolver una respuesta. Si existe un código de estado 201 en un método POST significa que se ha creado un recurso en una API distinta.

¿Qué código de estado HTTP y respuesta devolverá una operación que utiliza el método HTTP DELETE?
### Respuesta:
Los códigos de estado que puede devolver una operación que utiliza el método HTTP DELETE serán los siguientes: 200 todo ha ido correctamente y la respuesta muestra la descripcion del estado
<html>
  <body>
    <h1>File deleted.</h1>
  </body>
</html>
. Luego puede tener el código 204, y 202 donde en la respuesta no se muestra contenido. 

¿Qué código de respuesta HTTP devolverá una operación que sirve para conocer la información de un producto determinado? ¿Y si no lo encuentra?
### Respuesta:


Aplicación que simula un juego de disparo de Aviones

### Enunciado:
1. Realiza una aplicación que simule la persecución de dos aviones. Considerando los parámetros altura, velocidad y dirección, el avión perseguido puede trazar la ruta que quiera y cambiar su velocidad y altura y el avión perseguidor deberá modificar esos parámetros en la misma medida en que lo haga el primero. Puedes solicitar por consola cambiar los parámetros del avión perseguido o bien preparar un recorrido ya definido y lanzar la aplicación para ver como lo recorren ambos objetos (mostrando en cada instante los parámetros de cada uno)

2. Crea una aplicación en la que un ListView muestre el contenido de la lista, de forma que el ListView se actualice cada vez que se añadan elementos a la lista

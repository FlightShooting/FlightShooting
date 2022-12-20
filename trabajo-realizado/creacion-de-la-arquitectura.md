---
description: >-
  La arquitectura utilizada es con está divida en pequeñas fragmentos del
  proyecto para su fácil desarrollo y gestión por parte de un equipo
  principalmente telemático
---

# Creación de la Arquitectura

Primero tuvimos que separar las principales clases que veíamos a primera vista que deberúiamos tener en el proyecto si o si.

En una primera instancia pudimos sacar Avión, Escolta o Espía y un Aeropuerto.

<figure><img src="../.gitbook/assets/imgFS2.png" alt=""><figcaption><p>Inicio del proyecto</p></figcaption></figure>

Tomamos como patrón de diseño el patrón observador, el cuál consta de un objeto principal, que será nuestro avión, y una o unas clases dependientes, que será nuestra clase escolta. Con esto conseguimos resolver la forma de diseñar nuestro proyecto con éxito.

El éxito de uso de este patrón de diseño es que cuando el objeto principal, sea este nuestro avión, sufra o realice un cambio estado, éste se notificará a nuestros observadores que son dependientes de estos cambios de estado y por tanto se activará la llamada update() en el escolta para poder copiar la ruta de nuestro avión.

Así podremos apreciar como le persigue este 2ºAvión. En caso de un cambio de ruta sería posible que nuestro escolta sería capaz de volver a cargar la ruta gracias a la notificación recibida por el cambio de estado(la nueva ruta a seguir/trackear)

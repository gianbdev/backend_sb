# Rest API + JWT (SPRING BOOT)

## Descripción
Una API REST desarrollada con Spring Boot que utiliza JWT para autenticación. Este proyecto proporciona la autenticacion de usuarios y da acceso a una aplicacion tipo dashboard.

## Características
- **Autenticación JWT:** Protección de endpoints mediante tokens JWT.
- **Endpoints REST:** CRUD para Resgister y Login.
- **[HTTP]:** [CREATE, GET, POST , PUT , DELETE]

## Instalación
1. Clona el repositorio:
```bash
git clone <url-del-repositorio>
```

2. Navega al directorio del proyecto:
``` bash
cd <nombre-del-repositorio>
 ```

### Instala las dependencias y ejecuta el proyecto:

  ``` bash
    ./mvnw install
    ./mvnw spring-boot:run
  ```

### Configuración
application.properties: Configura las propiedades de tu aplicación.
JWT Configuration: Define la clave secreta y los parámetros de expiración en application.properties.

### Uso
* Ejemplo de solicitud GET a /api/example:

  ```bash
  curl -X GET "http://localhost:8080/api/example" -H "Authorization: Bearer <token>"
  ```

* Respuesta esperada:

```json

    {
      "key": "value"
    }
```

### Pruebas

* Ejecuta las pruebas unitarias y de integración con:

 ```bash
./mvnw test
```

### Contribución

Si deseas contribuir, por favor sigue estos pasos:

    Haz un fork del repositorio.
    Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
    Realiza tus cambios y haz un commit (git commit -am 'Añadir nueva funcionalidad').
    Haz un push a la rama (git push origin feature/nueva-funcionalidad).
    Envía un pull request.

Licencia

Este proyecto está licenciado bajo la Licencia MIT.
Autores y Reconocimientos

    Autor Principal: Giancarlo Silva (giancarlo.silva550@gmail.com)
    Reconocimientos: IBM, AWS, Microsoft, Oracle


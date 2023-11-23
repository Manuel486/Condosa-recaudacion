# Condosa Registrar Recaudacion Backend

Este proyecto de backend se centra en la gestión de recaudaciones para el sistema Condosa Registrar Recaudacion. Utiliza Spring Boot como framework de desarrollo para Java y PostgreSQL como base de datos relacional.

## Tecnologías Utilizadas

- **Spring Boot**: Framework de desarrollo para aplicaciones Java.
- **Spring Data JPA**: Acceso a datos utilizando Java Persistence API (JPA).
- **Spring Web**: Desarrollo de aplicaciones web con Spring.
- **PostgreSQL**: Sistema de gestión de bases de datos relacional.
- **Project Lombok**: Biblioteca para simplificar el código Java.
- **Spring Validation**: Soporte de validación para solicitudes HTTP.
- **Spring Boot Test**: Soporte para pruebas en aplicaciones Spring Boot.
- **Springdoc OpenAPI**: Generación automática de documentación OpenAPI para APIs RESTful.

## Configuración del Proyecto

Este proyecto utiliza Maven como herramienta de gestión de dependencias y construcción. Asegúrate de tener configurado tu entorno de desarrollo con Java 17.

## Estructura del Proyecto

La estructura del proyecto sigue las convenciones de un proyecto Spring Boot estándar. Aquí hay una breve descripción de los directorios principales:

- **src/main/java**: Contiene los archivos fuente de la aplicación Java.
- **src/main/resources**: Contiene archivos de recursos, como archivos de configuración y plantillas.
- **src/test**: Contiene pruebas unitarias y de integración.

## Ejecución del Proyecto

Para ejecutar el proyecto, puedes utilizar el complemento Maven para Spring Boot. Desde la línea de comandos, navega al directorio del proyecto y ejecuta el siguiente comando:

```bash
./mvnw spring-boot:run

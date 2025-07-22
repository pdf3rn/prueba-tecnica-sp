# Prueba Técnica

Este es un proyecto de prueba técnica desarrollado en Spring Boot.

## Requerimientos

- Java 21
- Maven 3.8+
- PostgreSQL 14 o superior


## Configuración y ejecución

1. Clonar el repositorio
2. Configurar la base de datos PostgreSQL

```bash
sudo -u postgres createdb prueba_pdfp
```

3. Configurar las credenciales de la base de datos en `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/prueba_pdfp
spring.datasource.username=postgres
spring.datasource.password=postgres
```

4. Cargar datos de prueba en la base de datos

```bash
cp dump.sql /tmp/dump.sql
sudo -u postgres psql prueba_pdfp -f /tmp/dump.sql 
```

5. Ejecutar la aplicación:
```bash
mvn clean spring-boot:run
```

La aplicación estará disponible en [http://localhost:8080](http://localhost:8080).

## Documentación de Swagger

La documentación de Swagger se encuentra disponible en [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

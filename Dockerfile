# Usa una imagen base de Maven para construir la aplicación
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml y las dependencias necesarias al contenedor
COPY pom.xml .

# Descarga las dependencias sin compilar (esto ayudará a aprovechar el caché en Docker)
RUN mvn dependency:go-offline

# Copia el código fuente del proyecto al contenedor
COPY src ./src

# Construye el proyecto y empaqueta en un archivo JAR
RUN mvn clean package -DskipTests

# Usa una imagen base de Java para ejecutar la aplicación
FROM openjdk:21-jdk

# Establece el directorio de trabajo para la aplicación
WORKDIR /app

# Copia el archivo JAR generado en la fase anterior al contenedor actual
COPY --from=build /app/target/poc-neo4j-service-0.0.1-SNAPSHOT.jar poc-neo4j-service.jar

# Expone el puerto en el que se ejecuta tu aplicación Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot cuando el contenedor se inicie
CMD ["java", "-jar", "poc-neo4j-service.jar"]

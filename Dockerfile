# Usa una imagen base de Java 21
FROM openjdk:21-jdk

# Copia el archivo JAR construido por tu proyecto Spring Boot al contenedor
ADD target/poc-neo4j-service-0.0.1-SNAPSHOT.jar poc-neo4j-service.jar

# Expone el puerto en el que se ejecuta tu aplicación Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot cuando el contenedor se inicie
CMD ["java", "-jar", "poc-neo4j-service.jar"]

#docker build -t poc-neo4j-service:1.0.0 . para poder crear una imagen
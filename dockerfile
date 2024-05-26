# Utiliza una imagen base de OpenJDK 11 como el entorno de ejecución
FROM openjdk:11-jre-slim

# Copia el archivo JAR ejecutable de tu aplicación al contenedor
COPY target/coachify-0.0.1-SNAPSHOT.jar /app.jar

# Define el comando que se ejecutará cuando el contenedor se inicie
CMD ["java", "-jar", "/app.jar"]

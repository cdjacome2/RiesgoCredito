# Usar una imagen base de Eclipse Temurin (OpenJDK 21)
FROM eclipse-temurin:21-jre-jammy

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR del microservicio generado por Maven al contenedor
COPY target/buro-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080 para acceder a la API
EXPOSE 8080

# Ejecutar el microservicio usando el archivo JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

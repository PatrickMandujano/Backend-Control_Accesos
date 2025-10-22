FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copiar jar
COPY build/libs/AccesoInsYUni-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Espera a MySQL antes de arrancar
ENTRYPOINT ["java", "-jar", "app.jar"]


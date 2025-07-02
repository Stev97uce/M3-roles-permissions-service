# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/roles-permissions-service-0.0.1-SNAPSHOT.jar /app/roles-permissions-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "roles-permissions-service.jar"]

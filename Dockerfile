# Etap 1: budowanie (z Mavenem)
FROM maven:3.9.9-eclipse-temurin-17-alpine AS builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

# Budujemy aplikację (ale nie testujemy)
RUN mvn clean package -DskipTests


# Etap 2: finalny, czysty obraz tylko z JAR-em
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Kopiujemy tylko gotowy artefakt z etapu buildera
COPY --from=builder /app/target/*.jar app.jar

# Ustaw port
EXPOSE 8080

# Uruchamiamy aplikację
ENTRYPOINT ["java", "-jar", "app.jar"]
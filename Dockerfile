# Wybierz obraz bazowy z JDK
FROM openjdk:17-jdk-slim

# Utwórz katalog na aplikację
WORKDIR /app

# Skopiuj plik jar do kontenera
COPY target/*.jar agent-ai-0.0.1-SNAPSHOT.jar

# Ustaw port
EXPOSE 8080

# Komenda uruchamiająca aplikację
ENTRYPOINT ["java", "-jar", "agent-ai-0.0.1-SNAPSHOT.jar"]

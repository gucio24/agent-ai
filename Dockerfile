# Wybierz obraz bazowy z JDK
FROM eclipse-temurin:17-jdk-alpine

# Utwórz katalog na aplikację
WORKDIR /app

# Skopiuj plik jar do kontenera
ARG JAR_FILE=package/*.jar
COPY ${JAR_FILE} app.jar

# Ustaw port
EXPOSE 8080

# Komenda uruchamiająca aplikację
ENTRYPOINT ["java", "-jar", "app.jar"]

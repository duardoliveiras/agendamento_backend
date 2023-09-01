FROM ubuntu:latest as build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
WORKDIR /app
COPY . .
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-jdk-slim
EXPOSE 8080
WORKDIR /app
COPY --from=build /build/libs/agendamento-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
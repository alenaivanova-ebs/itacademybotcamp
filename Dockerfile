FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY pom.xml /tmp/
COPY controller /tmp/controller/
COPY service /tmp/service/
COPY repo /tmp/repo/
WORKDIR /tmp/

FROM openjdk:17-jdk-slim
COPY /controller/target/itacademybotcamp.jar app.jar

EXPOSE 8080
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
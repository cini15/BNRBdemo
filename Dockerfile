FROM gradle:6.5-jdk11
EXPOSE 8080
WORKDIR /app
COPY / /app
RUN gradle build

#FROM openjdk:11
ENTRYPOINT java -jar /app/build/libs/demo-0.0.1-SNAPSHOT.jar
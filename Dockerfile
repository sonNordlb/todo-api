FROM openjdk:17-alpine3.13

COPY target/todoapi-0.0.1-SNAPSHOT.jar /server.war
EXPOSE 8080

CMD ["java", "-jar", "/server.war"]
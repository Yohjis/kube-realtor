FROM java:8

EXPOSE 8080

ADD target/Mediator-1.0-SNAPSHOT.jar clientService-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "Mediator-1.0-SNAPSHOT.jar"]
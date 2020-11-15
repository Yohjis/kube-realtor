FROM java:8

EXPOSE 8083

ADD target/clientService-1.0-SNAPSHOT.jar clientService-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "clientService-1.0-SNAPSHOT.jar"]
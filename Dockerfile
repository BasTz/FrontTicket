FROM openjdk:8-alpine3.9
ARG JAR_FILE=target/FrontTicket-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} FrontTicket.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/FrontTicket.jar"]
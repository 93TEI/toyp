FROM openjdk:17.0.2-oracle
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
FROM openjdk:8
VOLUME /tmp
ARG NAMING_SERVER_JAR_FILE
COPY ${NAMING_SERVER_JAR_FILE} naming_server.jar
ENTRYPOINT ["java", "-jar", "/naming_server.jar"]
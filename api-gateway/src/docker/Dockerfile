FROM openjdk:8
VOLUME /tmp
ARG API_GATEWAY_JAR_FILE
COPY ${API_GATEWAY_JAR_FILE} api_gateway.jar
ENTRYPOINT ["java", "-jar", "/api_gateway.jar"]
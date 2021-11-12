FROM openjdk:8
VOLUME /tmp
ARG CURRENCY_EXCHANGE_JAR_FILE
COPY ${CURRENCY_EXCHANGE_JAR_FILE} currency_exchange_app.jar
ENTRYPOINT ["java", "-jar", "/currency_exchange_app.jar"]
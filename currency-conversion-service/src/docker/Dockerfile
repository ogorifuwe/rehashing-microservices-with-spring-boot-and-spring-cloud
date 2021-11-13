FROM openjdk:8
VOLUME /tmp
ARG CURRENCY_CONVERSION_JAR_FILE
COPY ${CURRENCY_CONVERSION_JAR_FILE} currency_conversion_app.jar
ENTRYPOINT ["java", "-jar", "/currency_conversion_app.jar"]
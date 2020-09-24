FROM java:8

EXPOSE 8070

ARG JAR_FILE

ADD target/${JAR_FILE} /barista-service.jar

ENTRYPOINT ["java", "-jar","/barista-service.jar"]
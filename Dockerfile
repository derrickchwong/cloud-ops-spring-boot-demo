FROM openjdk:17
VOLUME /tmp
COPY target/*.jar app.jar
COPY m2c-demo-599331d7b44d.json /contact-api.json
ENTRYPOINT ["java","-jar","/app.jar"]
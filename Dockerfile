FROM openjdk:17

ARG JAR_FILE=build/libs/chat-gpt-box-service-*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=prod"]

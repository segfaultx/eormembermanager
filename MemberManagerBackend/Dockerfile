FROM amazoncorretto:17-alpine

ENV APP_JAR=build/libs/*.jar

COPY ${APP_JAR} /app.jar

ENTRYPOINT [ "java" , "-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "app.jar"]


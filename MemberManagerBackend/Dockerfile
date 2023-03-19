FROM amazoncorretto:17-alpine

COPY build/libs/MemberManagerBackend-0.0.1-SNAPSHOT.jar /

ENTRYPOINT [ "java" , "-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "MemberManagerBackend-0.0.1-SNAPSHOT.jar"]


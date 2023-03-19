FROM amazoncorretto:17-alpine

COPY build/libs/MemberManagerBackend-0.0.1-SNAPSHOT.jar /

ENTRYPOINT [ "java" , "-jar", "MemberManagerBackend-0.0.1-SNAPSHOT.jar"]


FROM openjdk:17
COPY build/libs/study-0.0.1-SNAPSHOT.jar study.jar
ENTRYPOINT ["java", "-jar", "study.jar"]
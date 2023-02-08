FROM openjdk:17
ADD /target/Assignment2-Patient-0.0.1-SNAPSHOT.jar Assignment2-Patient-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","Assignment2-Patient-0.0.1-SNAPSHOT.jar" ]
EXPOSE 8081
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/CustomerMS.jar
COPY ${JAR_FILE} CustomerMS.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/CustomerMS.jar"]
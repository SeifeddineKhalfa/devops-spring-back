FROM openjdk:11
MAINTAINER alanabli
ARG JAR_FILE=target/*.jar
RUN echo ${JAR_FILE}
ADD ${JAR_FILE} tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.jar"]
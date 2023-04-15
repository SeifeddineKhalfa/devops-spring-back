FROM openjdk:11
MAINTAINER alanabli
COPY devops-spring-back/target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.jar"]
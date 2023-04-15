FROM openjdk:11
MAINTAINER alanabli
WORKDIR /target
RUN ls -alh
ADD tpAchatProject-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.jar"]
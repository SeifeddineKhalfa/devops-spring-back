FROM openjdk:11
MAINTAINER alanabli
WORKDIR var/lib/jenkins/workspace/Spring\ IOC
RUN pwd && ls
ADD target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.jar"]
FROM openjdk:11
MAINTAINER alanabli
RUN cd /var/lib/jenkins/workspace/Spring\ IOC
ADD target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.jar"]
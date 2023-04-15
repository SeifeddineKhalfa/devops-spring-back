FROM openjdk:11
MAINTAINER alanabli
ADD /var/lib/jenkins/workspace/Spring\ IOC/target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.jar"]
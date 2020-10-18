FROM openjdk:11
MAINTAINER leo.com
VOLUME /tmp
EXPOSE 8080
ADD build/libs/demo-0.0.1-SNAPSHOT.jar springbootdemo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springbootdemo.jar"]

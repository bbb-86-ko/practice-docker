# base image
FROM adoptopenjdk:11-jre-hotspot
# image 생성한 사람
MAINTAINER bbb <bbb.86.ko@gmail.com>
# source jar
ARG JAR_FILE=build/libs/*.jar
# place in docker container
COPY ${JAR_FILE} app.jar
# execute
ENTRYPOINT ["java","-jar","/app.jar"]
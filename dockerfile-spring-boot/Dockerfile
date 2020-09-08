## base image
## ex) adoptopenjdk 11을 기준으로 image를 생성한다.
#FROM adoptopenjdk:11-jre-hotspot
## image 생성한 사람
#MAINTAINER bbb <bbb.86.ko@gmail.com>
## 이미지 위에서 스크립트 또는 명령을 실행한다.
## RUN 실행 결과는 캐시된다.(/bin/bash) 만약 캐시 결과를 사용하지 않으려면 build시 --no-cache 옵션을 추가하면된다.
## 쉘스크립트 없이 실행하려면 배열을 사용 (RUN ["apt-get", "install", "-y", "nginx"])
## ex) add group & user
##RUN addgroup -S spring && adduser -S spring -G spring
## 명령을 실행할 사용자 계정을 설정
##USER spring:spring
## source jar
#ARG JAR_FILE=target/*.jar
## place in docker container
#COPY ${JAR_FILE} app.jar
## 컨테이너가 시작되었을때 스크립트 또는 명령을 실행
## 컨테이너가 시작되었을때 = docker run or docker start
## docker run 옵션으로 사용할 수 있다. (docker run --entrypoint="")
#ENTRYPOINT ["java","-jar","/app.jar"]


FROM adoptopenjdk:11-jre-hotspot as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk:11-jre-hotspot
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

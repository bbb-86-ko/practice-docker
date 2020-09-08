# build docker container with dockerfile

### create Dockerfile (basic)
```shell script
# base image
FROM adoptopenjdk:11-jre-hotspot
# source jar
ARG JAR_FILE=target/*.jar
# place in docker container
COPY ${JAR_FILE} app.jar
# 컨테이너가 시작되었을때 스크립트 또는 명령을 실행
ENTRYPOINT ["java","-jar","/app.jar"]
```

### create Dockerfile (layering docker images)
```shell script
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
```

### build docker container
```shell script
docker build --build-arg JAR_FILE=build/libs/*.jar -t springio/dockerfile-spring-boot .
```

### run docker container
```shell script
docker run -p 8080:8080 springio/dockerfile-spring-boot
# Using Spring Profiles
docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 -t springio/gs-spring-boot-docker
``` 

### view docker images
```shell script
docker images
```

## gradle build 
> gradle bootBuildImage --imageName="docker.io/library/buildpack-spring-boot-run:0.0.1-RELEASE"

## run
> docker run -d -p 80:8080 docker.io/library/buildpack-spring-boot:0.0.1-SNAPSHOT




### reference

Dockerfile reference
<https://docs.docker.com/engine/reference/builder/>

Spring Boot with Docker
https://spring.io/guides/gs/spring-boot-docker/

Build OCI images with Cloud Native Buildpacks   
https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.3-Release-Notes#build-oci-images-with-cloud-native-buildpacks


What's new in Spring Boot 2.3   
https://spring.io/blog/2020/06/18/what-s-new-in-spring-boot-2-3

https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features

Writing the Dockerfile
https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#writing-the-dockerfile

Packaging Layered Jars
https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/html/#packaging-layered-jars

Packaging OCI Images   
<https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/gradle-plugin/reference/html/#build-image>

https://www.pyrasis.com/private/2014/11/30/publish-docker-for-the-really-impatient-book

https://spring.io/guides/topicals/spring-boot-docker/

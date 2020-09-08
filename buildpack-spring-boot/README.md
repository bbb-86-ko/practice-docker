# build oci images with cloud native buildpacks


## gradle build 
> gradle bootBuildImage --imageName="docker.io/library/buildpack-spring-boot-run:0.0.1-RELEASE"

## run
> docker run -d -p 80:8080 docker.io/library/buildpack-spring-boot:0.0.1-SNAPSHOT




### reference
Build OCI images with Cloud Native Buildpacks   
https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.3-Release-Notes#build-oci-images-with-cloud-native-buildpacks

Abount Open Container Initiative
https://opencontainers.org/

Creating a Docker image using Cloud Native Buildpacks in Spring Boot
https://medium.com/faun/creating-a-docker-image-using-cloud-native-buildpacks-in-spring-boot-19ff81b5209d

Creating Docker images with Spring Boot 2.3.0.M1
https://spring.io/blog/2020/01/27/creating-docker-images-with-spring-boot-2-3-0-m1

Packaging OCI Images   
<https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/gradle-plugin/reference/html/#build-image>

https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-container-images-buildpacks

https://paketo.io/
https://buildpacks.io/docs/
https://spring.io/guides/gs/spring-boot-docker/
https://spring.io/guides/topicals/spring-boot-docker/

What's new in Spring Boot 2.3   
https://spring.io/blog/2020/06/18/what-s-new-in-spring-boot-2-3
FROM openjdk:17
EXPOSE 8080
ADD target/springboot-employee-docker.jar springboot-employee-docker.jar
ENTRYPOINT [ "java","-jar","/springboot-employee-docker.jar" ]
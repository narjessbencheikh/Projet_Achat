FROM openjdk:11
EXPOSE 8089
ADD target/sirine100.jar sirine100.jar
ENTRYPOINT ["java","-jar","/sirine100.jar"]
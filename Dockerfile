FROM openjdk:8
ADD target/achat-1.0.jar stock.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "stock.jar"]
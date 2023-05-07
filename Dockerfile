FROM openjdk:16
ADD target/yaylunch-0.1.jar yaylunch-0.1.jar
ENTRYPOINT ["java", "-jar","yaylunch-0.1.jar"]
EXPOSE 8081
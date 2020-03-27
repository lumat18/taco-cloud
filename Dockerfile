FROM openjdk:11
ADD target/taco-cloud.jar   taco-cloud.jar
EXPOSE 8080
CMD java -jar taco-cloud.jar
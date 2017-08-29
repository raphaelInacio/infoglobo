FROM openjdk:8u121-jre-alpine
MAINTAINER Raphael Inacio da Silva <contato.raphaelinacio@gmail.com>
ADD target/feed-rest-api-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar --spring.data.mongodb.host=db"]

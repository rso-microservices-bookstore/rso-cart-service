FROM adoptopenjdk:15-jre-hotspot

RUN mkdir /app

WORKDIR /app

ADD ./target/rso-cart-service-1.0-SNAPSHOT.jar /app

EXPOSE 3002

CMD ["java", "-jar", "rso-cart-service-1.0-SNAPSHOT.jar"]
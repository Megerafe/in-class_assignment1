FROM openjdk:11-jre-slim


WORKDIR /app


COPY target/shopping-cart-1.0-SNAPSHOT.jar /app/shopping-cart.jar


ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-jar", "shopping-cart.jar"]
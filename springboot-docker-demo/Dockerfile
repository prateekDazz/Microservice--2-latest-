FROM eclipse-temurin:21

LABEL mentainer = "javaguides.net@gmail.com"


WORKDIR /app

COPY target/springboot-docker-demo-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "springboot-docker-demo-0.0.1-SNAPSHOT.jar"]


FROM eclipse-temurin:17-jre-alpine
COPY ./target/deportivo-0.0.1-SNAPSHOT.jar "app.jar"
EXPOSE 8114
ENTRYPOINT [ "java", "-jar", "app.jar" ]
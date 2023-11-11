FROM maven:3.9.5 AS build
COPY . .
RUN mvn clean package

FROM openjdk:17-jdk-slim AS runtime
COPY --from=build target/clients-0.0.1-SNAPSHOT.jar clients-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/clients-0.0.1-SNAPSHOT.jar"]
FROM maven:3.6.0-jdk-11-slim AS build
RUN mvn clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /boot/src/target/boot-0.0.1-SNAPSHOT.jar /usr/local/lib/vehicles.jar

EXPOSE 8080 8443 9990
ENTRYPOINT ["java","-jar","/usr/local/lib/vehicles.jar"]

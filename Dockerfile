FROM maven:3.6.0-jdk-11-slim AS build
COPY application /home/app/application
COPY boot /home/app/boot
COPY domain /home/app/domain
COPY infrastructure /home/app/infrastructure
COPY presentation /home/app/presentation
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/boot/target/boot-0.0.1-SNAPSHOT.jar /usr/local/lib/vehicles.jar

EXPOSE 8080 8443 9990
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/usr/local/lib/vehicles.jar"]

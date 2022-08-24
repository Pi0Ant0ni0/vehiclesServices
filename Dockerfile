FROM maven:3.6.0-jdk-11-slim AS build
COPY application /home/app/application
COPY boot /home/app/boot
COPY domain /home/app/domain
COPY infrastructure /home/app/infrastructure
COPY presentation /home/app/presentation
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install

#
# Package stage
#
FROM openjdk:11-jre-slim
ENV MONGO_DATABASE=vehicles
ENV MONGO_HOST=vehiclesdb.wcomp.svc.cluster.local:3306
ENV EUREKA_URL=http://eureka-naming-server.wcomp.svc.cluster.local:8080/eureka
ENV SPRING_PROFILES_ACTIVE=prod
COPY --from=build /home/app/boot/target/boot-0.0.1-SNAPSHOT.jar /usr/local/lib/vehicles.jar

EXPOSE 8080 8443 9990
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/usr/local/lib/vehicles.jar"]

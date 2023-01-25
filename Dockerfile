FROM eclipse-temurin:17

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN sed -i 's/\r$//' mvnw
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
#LABEL mentainer="ovunc.girgin@gmail.com"
#
#WORKDIR /app
#
#COPY target/caching-0.0.1-SNAPSHOT.jar /app/spring_boot_caching.jar
#
#ENTRYPOINT ["java","-jar","spring_boot_caching.jar"]
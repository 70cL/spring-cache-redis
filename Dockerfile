FROM eclipse-temurin:17

LABEL mentainer="ovunc.girgin@gmail.com"

WORKDIR /app

COPY target/caching-0.0.1-SNAPSHOT.jar /app/spring_boot_caching.jar

ENTRYPOINT ["java","-jar","spring_boot_caching.jar"]
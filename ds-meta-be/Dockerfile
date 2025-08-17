FROM openjdk:17-oracle

WORKDIR /app

ARG PROFILE

ENV PROJ_PROFILE=${PROFILE}

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=${PROJ_PROFILE}","-jar","/app/ds-meta-be.jar"]

VOLUME ["/app/config"]

COPY /target/ds-meta-be.jar .

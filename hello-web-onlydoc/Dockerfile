# java-backend with openjdk8(alpine)
# Author: Aaric
# Version: 1.0
# Build:
#   1. docker build --build-arg APP_NAME=java-backed \
#        --build-arg APP_VERSION=1.0 \
#        -t java-backed:1.0 .
# Testing:
#   1. docker run --rm -it --name backed -p 8080:8080 java-backend:1.0
#   2. docker exec -it backend ash
FROM openjdk:8u212-jre-alpine

MAINTAINER InCar

ARG APP_NAME=java-backed
ARG APP_VERSION=1.0

ENV APP_NAME=${APP_NAME} \
  APP_VERSION=${APP_VERSION}

EXPOSE 4000

WORKDIR /app

build/libs/${APP_NAME}-${APP_VERSION}.jar /app/deploy.jar

ENTRYPOINT ["java", "-jar", "deploy.jar", "-Dsun.net.http.allowRestrictedHeaders=true"]
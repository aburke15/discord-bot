# using multistage docker build
# ref: https://docs.docker.com/develop/develop-images/multistage-build/

# temp container to build using gradle
FROM gradle:5.3.0-jdk-alpine AS build
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME

COPY gradle $APP_HOME/gradle
COPY --chown=gradle:gradle . /home/gradle/src
USER root
RUN chown -R gradle /home/gradle/src

RUN gradle build || return 0
COPY . .
RUN gradle clean shadow

# actual container
FROM openjdk:11.0.13-jre
ENV ARTIFACT_NAME=DiscordBot-1.0-SNAPSHOT-all.jar
ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME
COPY --from=build $APP_HOME/build/libs/$ARTIFACT_NAME .

ENTRYPOINT exec java -jar ${ARTIFACT_NAME} "TOKEN"
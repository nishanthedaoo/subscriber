FROM openjdk:8-jdk-alpine
MAINTAINER codecentric.de
VOLUME /tmp
EXPOSE 8080

ENV USER_NAME monitoring
ENV APP_HOME /home/$USER_NAME/app

RUN adduser -D -u 1000 $USER_NAME
RUN mkdir $APP_HOME

ADD ["target/subscriber-0.0.1-SNAPSHOT.jar" ,"$APP_HOME/subscriber.jar"]
RUN chown $USER_NAME $APP_HOME/subscriber.jar

USER $USER_NAME
WORKDIR $APP_HOME
RUN touch subscriber.jar

ENTRYPOINT ["java","-jar","subscriber.jar"]
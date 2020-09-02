FROM openjdk:11-jre

COPY build/libs/schedulerDemo-0.0.1-SNAPSHOT.jar /app/app.jar
COPY docker/scheduler-entrypoint.sh /entrypoint.sh

CMD [ "entrypoint.sh" ]
FROM tomcat:10

RUN rm -rf /usr/local/tomcat/webapps/*

COPY /target/sem_docker-1.0-SNAPSHOT /usr/local/tomcat/webapps/ROOT

EXPOSE 8080
FROM java:8u40
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8
VOLUME /tmp
ADD registration.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8082




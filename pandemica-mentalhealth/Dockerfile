# Given the base image environment, SpringBoot projects typically package Docker as JDK or JRE
FROM java:8u102
# Declare a mount point. The path in the container will correspond to a folder on the host
VOLUME /tmp
# set the parameter added when compiling the image. JAR_FILE is
# the environment variable for setting the container (configured in Maven).
ARG JAR_FILE
# Adding a local file to a container
COPY target/mentalHealth.jar mentalHealth.jar
# Configure the container to make it executable. My understanding is to splice the start command
ENTRYPOINT ["java","-jar","/mentalHealth.jar"]
# Expose port 8084 externally
EXPOSE 8084






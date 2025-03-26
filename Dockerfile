# Use the official OpenJDK image as a base
FROM openjdk:21-jdk-slim

# Install curl
RUN apt-get update && apt-get install -y curl

# Set the working directory
WORKDIR /app

# Copy the application's JAR file into the container
COPY target/printing-*.jar final.jar

# Expose the port your application will run on
EXPOSE 9090

ENTRYPOINT ["java","-jar","final.jar"]
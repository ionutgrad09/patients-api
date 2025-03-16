# Use an OpenJDK 17 image with Alpine as the base image
FROM eclipse-temurin:17-jdk

# Copy the generated .jar file from the 'build/libs/' directory into the container
COPY build/libs/patients-api-0.0.1-SNAPSHOT.jar app.jar

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose port 8080 for the application
EXPOSE 8080
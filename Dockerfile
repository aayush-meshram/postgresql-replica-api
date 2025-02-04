# Use OpenJDK 17 as the base image
FROM openjdk:17-slim

# Set working directory
WORKDIR /app

# Copy the JAR file
COPY target/*.jar app.jar

# Expose the port your application runs on (adjust if needed)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
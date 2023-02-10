# Use an openjdk 17 image as the base image
FROM openjdk:17

# Set the working directory to /app
WORKDIR /app

# Copy the entire project to the container
COPY . .

# Run Maven to build the project
RUN ./mvnw clean install

# Run the generated jar file
CMD ["java", "-jar", "target/springBootTemplate-0.0.1-SNAPSHOT.jar"]

# Expose port 8080 for REST API requests
EXPOSE 8080

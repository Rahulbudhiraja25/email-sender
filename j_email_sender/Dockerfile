# Step 1: Use Maven to build the project (optional if already built externally)
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy the pom and source files
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Step 2: Create the actual runnable image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy the built jar from the previous image
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port (adjust if your app runs on a different port)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

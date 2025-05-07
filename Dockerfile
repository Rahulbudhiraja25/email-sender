# Use Maven to build the project
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy project files from the subdirectory
COPY j_email_sender/pom.xml .
COPY j_email_sender/src ./src

# Package the application
RUN mvn clean package -DskipTests

# Create final image with JDK
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

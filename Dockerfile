# Use an existing Maven and JDK 17 image
FROM maven:3.8-openjdk-17 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use the official lightweight Java 17 image.
FROM openjdk:17-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]

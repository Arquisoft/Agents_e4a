FROM maven:3.5-jdk-8-alpine
ADD ./ ./
RUN mvn package -DskipTests
EXPOSE 8081
CMD ["java", "-jar", "target/e4a_Agents-0.0.1.jar"]
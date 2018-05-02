FROM openjdk:8-jre-alpine
RUN mvn package -DskipTests
COPY ./target/e4a_Agents-0.0.1.jar /usr/src/app/
WORKDIR /usr/src/app
EXPOSE 8090
CMD ["java", "-jar", "e4a_Agents-0.0.1.jar"]
FROM maven:3.5-jdk-8-alpine
ADD ./ ./
RUN mvn package -DskipTests
RUN cd /target
COPY e4a_Agents-0.0.1.jar /usr/src/app/
WORKDIR /usr/src/app
EXPOSE 8090
CMD ["java", "-jar", "e4a_Agents-0.0.1.jar"]
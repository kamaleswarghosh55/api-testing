FROM maven:3.8.7-eclipse-temurin-11
WORKDIR /app
COPY . .
RUN mvn clean install
CMD ["mvn", "test"]
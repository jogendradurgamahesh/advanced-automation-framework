# FROM maven:3.9.6-eclipse-temurin-17
# WORKDIR /app
# COPY . .
# RUN mvn clean install
# CMD ["mvn","test"]


# FROM maven:3.9.6-eclipse-temurin-17

# WORKDIR /app

# COPY . .

# RUN mvn clean install -DskipTests

# CMD ["mvn", "test"]






FROM selenium/standalone-chrome:latest

USER root

# Install Maven
RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

CMD ["mvn", "test"]

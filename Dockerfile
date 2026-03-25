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





FROM maven:3.9.6-eclipse-temurin-17

# Install Chrome + dependencies
RUN apt-get update && apt-get install -y \
    wget unzip curl gnupg \
    libnss3 libgconf-2-4 libxi6 libxcursor1 libxcomposite1 \
    libxdamage1 libxtst6 libglib2.0-0 libnss3-dev libxrandr2 \
    libasound2 libatk1.0-0 libcups2 libxss1 libgtk-3-0 \
    && rm -rf /var/lib/apt/lists/*

# Install Chrome
RUN wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt-get update && apt-get install -y ./google-chrome-stable_current_amd64.deb

WORKDIR /app
COPY . .

RUN mvn clean install -DskipTests

CMD ["mvn", "test"]

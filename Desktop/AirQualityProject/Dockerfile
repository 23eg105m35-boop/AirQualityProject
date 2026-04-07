FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . /app

RUN find /app -name "*.java"

RUN javac $(find /app -name "*.java")

CMD ["java","MainApp"]

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . /app

RUN javac $(find /app -name "*.java")

CMD ["java","-cp","/app","MainApp"]

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN find . -name "*.java" -print

RUN javac $(find . -name "*.java")

CMD ["java","-cp","src","MainApp"]

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN find . -name "*.java"

RUN javac src/*.java

CMD ["java","-cp","src","MainApp"]

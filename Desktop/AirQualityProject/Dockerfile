FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY src ./src
COPY dashboard.html .
COPY data ./data

RUN javac src/*.java

CMD ["java","-cp","src","MainApp"]

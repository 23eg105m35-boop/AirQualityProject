FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY Desktop/AirQualityProject /app

WORKDIR /app

RUN javac src/*.java

CMD ["java","-cp","src","MainApp"]

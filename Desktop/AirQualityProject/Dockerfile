FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN javac Desktop/AirQualityProject/src/*.java

CMD ["java","-cp","Desktop/AirQualityProject/src","MainApp"]

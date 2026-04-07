FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN javac src/AQIPredictor.java src/CityHotspotAnalyzer.java src/DataLoader.java src/HealthAdvisor.java src/HotspotDetector.java src/MainApp.java

CMD ["java","-cp","src","MainApp"]
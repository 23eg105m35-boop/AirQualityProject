FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY src /app/src
COPY data /app/data

RUN javac /app/src/*.java

CMD ["java","-cp","/app/src","MainApp"]

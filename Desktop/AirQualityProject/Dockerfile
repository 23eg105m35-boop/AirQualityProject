FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN cd src && javac *.java

CMD ["java","-cp","src","MainApp"]

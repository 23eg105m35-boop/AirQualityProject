import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.*;
import java.net.InetSocketAddress;
import java.util.*;

public class MainApp {


static List<String[]> dataset = new ArrayList<>();

public static void main(String[] args) throws Exception {

    loadDataset();

    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

    server.createContext("/data", MainApp::handleData);

    server.start();

    System.out.println("Server started at http://localhost:8000");
}

static void loadDataset() throws Exception {

    BufferedReader br = new BufferedReader(
        new FileReader("C:/Users/vikas/OneDrive/Desktop/AirQualityProject/data/city_day.csv")
    );

    String line;

    br.readLine(); // skip header

    while((line = br.readLine()) != null){

        String[] row = line.split(",");

        if(row.length > 9 &&
           !row[2].isEmpty() &&
           !row[3].isEmpty() &&
           !row[5].isEmpty()){

            dataset.add(row);
        }
    }

    br.close();

    System.out.println("Dataset loaded: " + dataset.size() + " rows");
}

static void handleData(HttpExchange exchange) throws IOException {

    Random rand = new Random();

    String[] row = dataset.get(rand.nextInt(dataset.size()));

    String city = row[0];

    double pm25 = Double.parseDouble(row[2]);
    double pm10 = Double.parseDouble(row[3]);
    double no2  = Double.parseDouble(row[5]);

    // AQI approximation using highest pollutant
    double aqi = Math.max(pm25, Math.max(pm10, no2));

    double gas = pm25;

    int temperature = 20 + rand.nextInt(15);

    int humidity = 40 + rand.nextInt(40);

    String json =
    "{"+
    "\"city\":\""+city+"\","+
    "\"pm25\":"+pm25+","+
    "\"pm10\":"+pm10+","+
    "\"no2\":"+no2+","+
    "\"gas\":"+gas+","+
    "\"temperature\":"+temperature+","+
    "\"humidity\":"+humidity+","+
    "\"aqi\":"+aqi+
    "}";

    exchange.getResponseHeaders().add("Content-Type","application/json");

    exchange.getResponseHeaders().add("Access-Control-Allow-Origin","*");

    exchange.sendResponseHeaders(200,json.length());

    OutputStream os = exchange.getResponseBody();

    os.write(json.getBytes());

    os.close();
}


}

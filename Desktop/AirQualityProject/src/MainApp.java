import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MainApp {

    static List<String[]> dataset = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        loadDataset();

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/data", MainApp::handleData);

        server.setExecutor(null);

        server.start();

        System.out.println("Server started at http://localhost:8000/data");
    }

    // load csv dataset
    static void loadDataset() throws Exception {

        BufferedReader br = new BufferedReader(
                new FileReader("../data/city_day.csv")
        );

        String line;

        br.readLine(); // skip header

        while ((line = br.readLine()) != null) {

            String[] row = line.split(",");

            // check required columns not empty
            if (row.length > 15 &&
                    !row[0].trim().isEmpty() &&
                    !row[7].trim().isEmpty() &&
                    !row[8].trim().isEmpty() &&
                    !row[10].trim().isEmpty()) {

                dataset.add(row);
            }
        }

        br.close();

        System.out.println("Dataset loaded successfully");
        System.out.println("Total rows = " + dataset.size());
    }

    // API method
    static void handleData(HttpExchange exchange) throws IOException {

        Random random = new Random();

        String[] row = dataset.get(random.nextInt(dataset.size()));

        String city = row[0].trim();

        double pm25 = Double.parseDouble(row[7].trim());
        double pm10 = Double.parseDouble(row[8].trim());
        double no2 = Double.parseDouble(row[10].trim());

        // calculate AQI (simple logic)
        double aqi = Math.max(pm25, Math.max(pm10, no2));

        // additional simulated values
        int temperature = 20 + random.nextInt(15);
        int humidity = 40 + random.nextInt(40);

        double gas = pm25;

        String json =
                "{"
                        + "\"city\":\"" + city + "\","
                        + "\"pm25\":" + pm25 + ","
                        + "\"pm10\":" + pm10 + ","
                        + "\"no2\":" + no2 + ","
                        + "\"gas\":" + gas + ","
                        + "\"temperature\":" + temperature + ","
                        + "\"humidity\":" + humidity + ","
                        + "\"aqi\":" + aqi
                        + "}";

        byte[] response = json.getBytes(StandardCharsets.UTF_8);

        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");

        exchange.sendResponseHeaders(200, response.length);

        OutputStream os = exchange.getResponseBody();

        os.write(response);

        os.close();
    }
}
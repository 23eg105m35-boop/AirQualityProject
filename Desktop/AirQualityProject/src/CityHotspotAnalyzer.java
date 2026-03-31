import java.io.*;
import java.util.*;

public class CityHotspotAnalyzer {

    public static void analyze(String filePath){

        Map<String, List<Double>> cityAQI = new HashMap<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            br.readLine(); // skip header

            while((line = br.readLine()) != null){

                String[] values = line.split(",");

                try {

                    String city = values[0];
                    double aqi = Double.parseDouble(values[9]);

                    cityAQI.putIfAbsent(city, new ArrayList<>());
                    cityAQI.get(city).add(aqi);

                } catch(Exception e){}

            }

            br.close();

        } catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("\nAverage AQI by City:\n");

        String worstCity = "";
        double worstAQI = 0;

        for(String city : cityAQI.keySet()){

            List<Double> list = cityAQI.get(city);

            double sum = 0;

            for(double val : list)
                sum += val;

            double avg = sum / list.size();

            System.out.println(city + " -> " + avg);

            if(avg > worstAQI){
                worstAQI = avg;
                worstCity = city;
            }
        }

        System.out.println("\nMost Polluted City: " + worstCity);
        System.out.println("Average AQI: " + worstAQI);
    }
}
import java.io.*;
import java.util.*;

public class DataLoader {

    public static List<double[]> loadData(String filePath) {

        List<double[]> dataset = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");

                try {

                    double pm25 = Double.parseDouble(values[2]);
                    double pm10 = Double.parseDouble(values[3]);
                    double no2 = Double.parseDouble(values[5]);
                    double co = Double.parseDouble(values[6]);
                    double so2 = Double.parseDouble(values[7]);
                    double aqi = Double.parseDouble(values[9]);

                    dataset.add(new double[]{pm25, pm10, no2, co, so2, aqi});

                } catch(Exception e) {}

            }

            br.close();

        } catch(Exception e){
            e.printStackTrace();
        }

        return dataset;
    }
}
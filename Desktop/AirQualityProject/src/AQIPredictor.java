public class AQIPredictor {

    public static double predict(double pm25, double pm10, double no2, double co, double so2) {

        double aqi = (pm25 * 0.4) +
                     (pm10 * 0.3) +
                     (no2 * 0.1) +
                     (co * 50) +
                     (so2 * 0.2);

        return aqi;
    }
}
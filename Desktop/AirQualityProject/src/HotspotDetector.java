public class HotspotDetector {

    public static String detectLevel(double aqi){

        if(aqi <= 50)
            return "Good";

        else if(aqi <= 100)
            return "Moderate";

        else if(aqi <= 200)
            return "Unhealthy";

        else if(aqi <= 300)
            return "Very Unhealthy";

        else
            return "Hazardous";
    }
}
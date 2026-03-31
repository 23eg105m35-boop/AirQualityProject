public class HealthAdvisor {

    public static String getAdvice(double aqi){

        if(aqi <= 50)
            return "Air quality is good.";

        else if(aqi <= 100)
            return "Sensitive groups should reduce outdoor activity.";

        else if(aqi <= 200)
            return "Wear mask and avoid long outdoor exposure.";

        else if(aqi <= 300)
            return "Avoid outdoor activity.";

        else
            return "Stay indoors and use air purifier.";
    }
}
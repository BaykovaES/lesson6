package HWlesson7;

public class Weather {



    private static String date;
    private static String weather;
    private static String temperature;

    public Weather() {

        this.date = date;
        this.weather = weather;
        this.temperature = temperature;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public static String getDate() {
        return date;
    }

    public static String getWeather() {
        return weather;
    }

    public static String getTemperature() {
        return temperature;
    }
    @Override
    public String toString() {
        return "Weather{" +
                "date=" + date +
                ", weather=" + weather +
                ", temperature=" + temperature + "F" +
                '}';
    }
}

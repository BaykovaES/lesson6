package HWlesson7;

public class Weather {
    private String date;
    private String weather;
    private String temperature;

    public Weather(String date, String weather, String temperature) {
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

    public String getDate() {
        return date;
    }

    public String getWeather() {
        return weather;
    }

    public String getTemperature() {
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

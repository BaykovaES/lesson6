package HWlesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

public class WeatherResponse {
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static ObjectMapper objectMapper = new ObjectMapper();

    private static final String API_KEY = "yXlefhnwJzM6GkMJ9u4idD2cbWC6F0k2";


    public static Weather getWeather(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("1day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();


        Request request = new Request.Builder()
                .url(httpUrl)
                .build();


        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String date = null;
        String weather = null;
        String temperature = null;
        try {

            date = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(0)
                    .at("/Date")
                    .asText();

            weather = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(0)
                    .at("/Day/IconPhrase")
                    .asText();

            temperature = objectMapper.readTree(json)
                    .at("/DailyForecasts")
                    .get(0)
                    .at("/Temperature/Minimum/Value")
                    .asText();

        } catch (NullPointerException e) {
            System.out.println("Response in null");
            e.printStackTrace();
        }


        return new Weather(date, weather, temperature);
    }
    public static ArrayList<Weather> getWeather5day(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)
                .addQueryParameter("apikey", API_KEY)
                .build();


        Request request = new Request.Builder()
                .url(httpUrl)
                .build();


        Response response = okHttpClient.newCall(request).execute();

        String json = response.body().string();

        String date = null;
        String weather = null;
        String temperature = null;
        ArrayList<Weather> list = new ArrayList<>();
        int day;
        for (day = 0; day <= 4; day++) {
            try {


                date = objectMapper.readTree(json)
                        .at("/DailyForecasts")
                        .get(day)
                        .at("/Date")
                        .asText();

                weather = objectMapper.readTree(json)
                        .at("/DailyForecasts")
                        .get(day)
                        .at("/Day/IconPhrase")
                        .asText();

                temperature = objectMapper.readTree(json)
                        .at("/DailyForecasts")
                        .get(day)
                        .at("/Temperature/Minimum/Value")
                        .asText();


            } catch (NullPointerException e) {
                System.out.println("Response in null");
                e.printStackTrace();
            }

            list.add(new Weather(date, weather, temperature));

        }

        return list;
    }


    public static String getCityId(String cityInText) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", cityInText)
                .build();


        Request request = new Request.Builder()
                .url(httpUrl)
                .build();


        Response response = okHttpClient.newCall(request).execute();



        String cityId = null;
        try {
            cityId = objectMapper.readTree(response.body().string())
                    .get(0)
                    .at("/Key")
                    .asText();
        } catch (NullPointerException e) {
            System.out.println("Response in null");
            e.printStackTrace();
        }

        return cityId;
    }
}

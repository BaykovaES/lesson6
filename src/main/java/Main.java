import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClientclient = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("developer.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("294021") //yXlefhnwJzM6GkMJ9u4idD2cbWC6F0k2
                .addQueryParameter("apikey", "yXlefhnwJzM6GkMJ9u4idD2cbWC6F0k2")
                .addQueryParameter("language", "en-us")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = okHttpClientclient.newCall(request).execute();

        System.out.println(response.body().string());
        
    }
}

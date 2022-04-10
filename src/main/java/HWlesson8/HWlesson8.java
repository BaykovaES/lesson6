package HWlesson8;

import HWlesson7.Weather;
import HWlesson7.WeatherResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class HWlesson8 {

    static String cityName;
    public static void main(String[] args) throws IOException, SQLException {
        while (true) {
            System.out.println("--= Введите название города на английском или history для вывода истории запросов (для выхода из программы наберите 'exit') =--");
            Scanner sc = new Scanner(System.in);
            String cityName = sc.nextLine();

            if (cityName.equals("exit")) {
                break;
            } else if (cityName.equals("history")) {
                System.out.println(HandlerDB.getWeatherHistory());
            } else {
                String cityId = WeatherResponse.getCityId(cityName);

                    System.out.println(cityName + " " + WeatherResponse.getWeather(cityId));
                    System.out.println(cityName + " " + WeatherResponse.getWeather5day(cityId));
                }
                HandlerDB.addResponse(new Weather());

            }
        }
    }


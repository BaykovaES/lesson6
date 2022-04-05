package HWlesson7;

import java.io.IOException;
import java.util.Scanner;

public class HWlesso7 {

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("--= Введите город (для выхода из программы наберите 'exit') =--");
            Scanner sc = new Scanner(System.in);
            String cityName = sc.nextLine();
            if (cityName.equals("exit")) {
                break;
            }
            else {
                String cityId = WeatherResponse.getCityId(cityName);

                System.out.println(cityName + " " + WeatherResponse.getWeather(cityId));
                System.out.println(cityName + " " + WeatherResponse.getWeather5day(cityId));

            }

        }
    }







}

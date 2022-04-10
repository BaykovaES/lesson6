package HWlesson8;

import HWlesson7.Weather;
import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HandlerDB {
    private static final String DB_PATH = "jdbc:sqlite:src/main/java/sqlite3.db";
    private static Connection connection;


    public HandlerDB() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(DB_PATH);
    }

        public static void addResponse(Weather weather){
            try
                 (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT UNTO weatherRequests (city,localDate,weatherText,temperature) VALUES (?,?,?,?)"))
                {
                     preparedStatement.setObject(1, HWlesson8.cityName);
                     preparedStatement.setObject(2,  Weather.getDate());
                     preparedStatement.setObject(3,  Weather.getWeather());
                     preparedStatement.setObject(4,  Weather.getTemperature());
                     preparedStatement.execute();
                }catch (SQLException sqlException){
                    sqlException.printStackTrace();
                }
        }

        public static List<Weather> getWeatherHistory() {

            List<Weather> weatherHistory = new ArrayList<>();
            try (Statement statement = connection.createStatement()){

                  ResultSet resultSet = statement.executeQuery(
                          "SELECT city,localDate,weatherText,temperature FROM weatherRequests");
                  while (resultSet.next()) {
                      weatherHistory.add(
                              new Weather(

                              )
                      );
                  }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();

            }

            return weatherHistory;
        }






}


package com.kodigo.weather;

import java.io.IOException;

public class DailyForecastTest {

	public static void main(String[] args) throws IOException {
		OpenWeatherMap owm = new OpenWeatherMap("653187e16e4bf3b0325c18bb6ee348ac");
        DailyForecast df = owm.dailyForecastByCityName("London, UK", Byte.parseByte("5"));

        if (!df.isValid()) {
            System.out.println("Reponse is inValid!");
        } else {
            System.out.println("Reponse is Valid!");
            System.out.println();

            if (df.hasCityInstance()) {
                DailyForecast.City city = df.getCityInstance();
                if (city.hasCityName()) {
                    if (city.hasCityCode()) {
                        System.out.println("City code: " + city.getCityCode());
                    }
                    if (city.hasCityName()) {
                        System.out.println("City name: " + city.getCityName());
                    }
                    System.out.println();
                }
            }

            System.out.println("Total forecast instances: " + df.getForecastCount());
            System.out.println();

            for (int i = 0; i < df.getForecastCount(); i++) {
                DailyForecast.Forecast forecast = df.getForecastInstance(i);

                System.out.println("*** Forecast instance number " + (i+1) + " ***");

                if (forecast.hasDateTime()) {
                    System.out.println(forecast.getDateTime());
                }

                System.out.println();
            }
        }
    }
}

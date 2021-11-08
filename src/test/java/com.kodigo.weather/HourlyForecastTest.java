package com.kodigo.weather;

import java.io.IOException;

public class HourlyForecastTest {

	public static void main(String[] args) throws IOException {
        OpenWeatherMap owm = new OpenWeatherMap("653187e16e4bf3b0325c18bb6ee348ac");
        HourlyForecast hf = owm.hourlyForecastByCityName("London, UK");

        if (!hf.isValid()) {
            System.out.println("Reponse is inValid!");
        } else {
            System.out.println("Reponse is Valid!");
            System.out.println();

            if (hf.hasCityInstance()) {
                HourlyForecast.City city = hf.getCityInstance();
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

            System.out.println("Total forecast instances: " + hf.getForecastCount());
            System.out.println();

            for (int i = 0; i < hf.getForecastCount(); i++) {
                HourlyForecast.Forecast forecast = hf.getForecastInstance(i);

                System.out.println("*** Forecast instance number " + (i+1) + " ***");

                if (forecast.hasDateTime()) {
                    System.out.println(forecast.getDateTime());
                }

                System.out.println();
            }
        }
    }
}

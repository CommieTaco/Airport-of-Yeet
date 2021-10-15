package com.kodigo.weather;

import java.io.IOException;

public class CurrentWeatherTest {

	public static void main(String[] args) throws IOException {
		OpenWeatherMap owm = new OpenWeatherMap("653187e16e4bf3b0325c18bb6ee348ac");
        CurrentWeather cw = owm.currentWeatherByCityName("London, UK");

        if (!cw.isValid()) {
            System.out.println("Reponse is inValid!");
        } else {
            System.out.println("Reponse is Valid!");
            System.out.println();

            if (cw.hasBaseStation()) {
                System.out.println("Base station: " + cw.getBaseStation());
            }
            if (cw.hasDateTime()) {
                System.out.println("Date time: " + cw.getDateTime());
            }
            System.out.println();


            if (cw.hasCityCode()) {
                System.out.println("City code: " + cw.getCityCode());
            }
            if (cw.hasCityName()) {
                System.out.println("City name: " + cw.getCityName());
            }
            System.out.println();
        }
	}

}

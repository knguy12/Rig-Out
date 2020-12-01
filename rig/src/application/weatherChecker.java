package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class weatherChecker {
	public String getTemp() throws IOException {
		// test
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q=San%20Jose&appid=6089342a45d76e01e12c36bd94042e73&units=imperial";
		StringBuilder result = new StringBuilder();

		// reads the data from weather API
		try {
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output;

			while ((output = rd.readLine()) != null) {
				result.append(output);
			}

			rd.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// Parses the JSON data and finds the temperature value
		String temp = result.toString();
		String[] totalJSON = temp.split("\\{");
		temp = totalJSON[4].substring(7, 12);
		return temp;
	}
	// Checks if the weather is currently hot or cold
	public String hotOrCold() throws NumberFormatException, IOException {
		if (Double.parseDouble(getTemp()) < 70.0)
			return "cold";
		return "hot";
	}

	public static void main(String[] args) throws IOException {
		weatherChecker check = new weatherChecker();
		String temperature = check.getTemp();
		System.out.print(temperature + " " + "degrees fahrenheit");
	}
}

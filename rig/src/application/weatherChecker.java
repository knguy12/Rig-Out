package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class weatherChecker {
	public String getTemp() throws IOException {
	
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q=San%20Jose&appid=6089342a45d76e01e12c36bd94042e73&units=imperial";
		StringBuilder result = new StringBuilder();
		
		try {
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output;
			
			while((output = rd.readLine()) != null){
				result.append(output);
			}
	
			rd.close();
		} 
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String temp = result.toString().substring(147, 152);
		return temp;
	}
	public static void main(String[] args) throws IOException {
		weatherChecker check = new weatherChecker();
		String temperature = check.getTemp();
		System.out.print(temperature);
	}
}

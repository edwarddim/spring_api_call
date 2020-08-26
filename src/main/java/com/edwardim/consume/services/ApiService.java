package com.edwardim.consume.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
	public JSONObject getStarWars() throws Exception {
		try {
			// DEFINE MY CONNECTION
			String poke_api = "https://pokeapi.co/api/v2/pokemon/ditto";
			String sw_api = "https://swapi.dev/api/people/1/";
			URL url = new URL(sw_api);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("User-Agent", "Spring");
			// TEST MY CONNECTION
			if(conn.getResponseCode() != 200 ) {
				throw new RuntimeException("Failed request. HTTP ERROR CODE: " + conn.getResponseCode());
			}
			// GETTING RESPONSE FROM API
			InputStreamReader input = new InputStreamReader(conn.getInputStream());
			// READING THE RESPONSE
			BufferedReader br = new BufferedReader(input);
			String output;
			JSONObject json = new JSONObject();
			while((output = br.readLine()) != null) {
				System.out.println(output);
				json = new JSONObject(output);
				return json;
			}
			conn.disconnect();
			return null;
		}
		catch (Exception e) {
			throw e;
		}
	}
}

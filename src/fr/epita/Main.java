package fr.epita;
import java.io.BufferedReader;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.epita.domain.Regularity;

public class Main {

	private final static String FILENAME = "/regularite-mensuelle-tgv-axes.csv";
	private final static String DELIMITER = ";";
	
	
	public static void main(String[] args) {
		
		List<Regularity> regularities = new ArrayList<>();
		
		try {
			//Get file from project resources as stream
			InputStream inputStream = ClassLoader.class.getResourceAsStream(FILENAME);
			//Create a buffered reader to read it line by line
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			
			//Handling the headers
			String line = reader.readLine();
			
			String[] headers  = line.split(DELIMITER);
			
			line = reader.readLine();
			
			while (line != null) {
				Regularity regularity = new Regularity();
				
				String[] values = line.split(DELIMITER);
				
				// Filled the regularity object with the line values
				regularity.setYear(Integer.parseInt(values[0]));
				regularity.setMonth(Integer.parseInt(values[1]));
				regularity.setRegion(values[2]);
				regularity.setRegularity(Double.parseDouble(values[3]));
				regularity.setPunctuality(Double.parseDouble(values[5]));
				
				// Append the object to the list
				regularities.add(regularity);
				
				line = reader.readLine();
			}
			 
			// serialize json object
			Gson gson = new Gson();
			String out = gson.toJson(regularities);
			
			// deserialize the json
			Regularity[] deserialized = gson.fromJson(out, Regularity[].class);
						
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//convertCsvToJsonManually();
		
	}


	private static void convertCsvToJsonManually() {
		try {
			//Get file from project resources as stream
			InputStream inputStream = ClassLoader.class.getResourceAsStream(FILENAME);
			//Create a buffered reader to read it line by line
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			
			//Handling the headers
			String line = reader.readLine();
			
			String[] headers  = line.split(DELIMITER);
			
			System.out.println("[");
			reader.readLine();
			
			while(line != null) {
				
				String[] values = line.split(DELIMITER);
				
				System.out.print("{");
				
				for (int i = 0; i < headers.length; ++i) {
					System.out.print("\"" + headers[i] + "\": \"" + values[i] + "\"");
					if (i < headers.length - 1) {
						System.out.print(",");
					}
				}
				
				System.out.println("},");
				
				line = reader.readLine();
			}
			
			System.out.println("]");
			
			//Handling the data
			//TODO implement this section
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

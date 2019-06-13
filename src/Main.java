import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {

	private final static String FILENAME = "/regularite-mensuelle-tgv-axes.csv";
	private final static String DELIMITER = ";";
	
	
	public static void main(String[] args) {
				
		try {
			//Get file from project resources as stream
			InputStream inputStream = ClassLoader.class.getResourceAsStream(FILENAME);
			//Create a buffered reader to read it line by line
//			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			Scanner sc = new Scanner(new InputStreamReader(inputStream, "UTF-8"));
			
			//Handling the headers
			String line = sc.nextLine();
			String[] headers  = line.split(DELIMITER);
			
			for (String header : headers) {
				System.out.print(header + " | ");
			}
			
			//to transform CSV to JSON
			JSONObject obj = new JSONObject();
			JSONArray jArray = new JSONArray();
			
			
			//Handling the values
			while(sc.hasNext())
			{
				
				String lineValues = sc.nextLine();
				String[] values  = lineValues.split(DELIMITER);
				
				for (int i=0;i<values.length;i++) {
					  obj.put(headers[i], values[i]);
				}
				//this are just test displays
				System.out.print(obj);
				jArray.add(obj);
				System.out.println("\n");
			}
			//this are test displays
			System.out.println(jArray);
			
			//Handling the data
			//TODO implement this section
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

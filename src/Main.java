import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

	private final static String FILENAME = "/regularite-mensuelle-tgv-axes.csv";
	private final static String DELIMITER = ";";
	
	
	public static void main(String[] args) {
				
		try {
			//Get file from project resources as stream
			InputStream inputStream = ClassLoader.class.getResourceAsStream(FILENAME);
			//Create a buffered reader to read it line by line
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			
			//Handling the headers
			String line = reader.readLine();
			
			String[] headers  = line.split(DELIMITER);
			
			for (String header : headers) {
				System.out.print(header + " | ");
			}
			
			//Handling the data
			//TODO implement this section
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

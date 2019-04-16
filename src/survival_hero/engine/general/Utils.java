package survival_hero.engine.general;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Utils {

	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null) {
				builder.append(line + "\n");
			}
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	
	
	public static Document readXMLFile(String path) {
		Document doc = null;
		try {
			File file = new File(path);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(file);
			
			doc.getDocumentElement().normalize();
//			System.out.println(doc.getDocumentElement().getNodeName());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return doc;
		
	}
	
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int parseInt(char number) {
		try {
			return Character.getNumericValue(number);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	
	}
	
}

package Pack1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String encodedfile = null;
		//Get this file path using JFileChooser instead
		String filePath = "/home/akshay/cs/oopmproj/testimg.jpg";
		File file = new File(filePath);
		
		String extension = "";
		int i = filePath.lastIndexOf('.');
		if (i > 0) {
		    extension = filePath.substring(i+1);
		}
		
		Base64.Encoder encoder = Base64.getEncoder();
	    try {
	        FileInputStream fileInputStreamReader = new FileInputStream(file);
	        byte[] bytes = new byte[(int)file.length()];
	        fileInputStreamReader.read(bytes);
	        encodedfile = encoder.encodeToString(bytes).toString();
	        
	    } catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
	    
		String name = "MissingPerson'sNameHere";
		try {
			HttpResponse<JsonNode> fileUpR = Unirest.post("http://localhost:5000/gpr")
					.header("Content-Type", "application/json")
			        .header("accept", "application/json")
			        .body("{\"key\":\"!!MyKey@123eOOPM\", \"file\":\""+encodedfile+"\", \"name\":\""+name+"\", \"extension\":\""+extension+"\"}")
					.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
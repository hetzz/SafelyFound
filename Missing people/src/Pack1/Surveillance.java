package Pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.http.NoHttpResponseException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import net.proteanit.sql.DbUtils;

public class Surveillance {
	//public static String urlc = "https://oopmproj4751.localtunnel.me";
	public static String urlc = "http://192.168.15.151:5000";
	public static void startSurveillance() {
		// TODO Auto-generated method stub
		try {
			HttpResponse<JsonNode> startR = Unirest.post(urlc+"/start")
			        .header("Content-Type", "application/json")
			        .header("accept", "application/json")
			        .body("{\"key\":\"!!MyKey@123eOOPM\"}")
			        .asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}
	public static void stopSurveillance(){
		
		try {
			HttpResponse<JsonNode> stopR = Unirest.post(urlc+"/stop")
			        .header("Content-Type", "application/json")
			        .header("accept", "application/json")
			        .body("{\"key\":\"!!MyKey@123eOOPM\"}")
			        .asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
			if(e.getCause() instanceof NoHttpResponseException) {
				try {
					Thread.sleep(30);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				try {
					HttpResponse<JsonNode> stopR1 = Unirest.post(urlc+"/stop")
					        .header("Content-Type", "application/json")
					        .header("accept", "application/json")
					        .body("{\"key\":\"!!MyKey@123eOOPM\"}")
					        .asJson();
				} catch (UnirestException e2) {
					e2.printStackTrace();
				}
			}
			
			
		}
	}

	
}

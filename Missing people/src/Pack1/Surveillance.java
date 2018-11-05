package Pack1;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Surveillance {

	public static void startSurveillance() {
		// TODO Auto-generated method stub
		try {
			HttpResponse<JsonNode> startR = Unirest.post("http://oopmproj4751.localtunnel.me/start")
			        .header("Content-Type", "application/json")
			        .header("accept", "application/json")
			        .body("{\"key\":\"!!MyKey@123eOOPM\"}")
			        .asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void stopSurveillance(){
		
		try {
			HttpResponse<JsonNode> stopR = Unirest.post("https://oopmproj4751.localtunnel.me/stop")
			        .header("Content-Type", "application/json")
			        .header("accept", "application/json")
			        .body("{\"key\":\"!!MyKey@123eOOPM\"}")
			        .asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

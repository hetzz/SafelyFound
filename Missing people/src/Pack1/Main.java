package Pack1;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			HttpResponse<JsonNode> startR = Unirest.post("http://localhost:5000/start")
			        .header("Content-Type", "application/json")
			        .header("accept", "application/json")
			        .body("{\"key\":\"!!MyKey@123eOOPM\"}")
			        .asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			HttpResponse<JsonNode> stopR = Unirest.post("http://localhost:5000/stop")
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

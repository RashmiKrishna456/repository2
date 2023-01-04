package authentication;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class auth2 {
	@Test
	public void authentication(){
		
		 Response response = given()
				.formParam("client_id", "SDET43")
				.formParam("client_secret", "b3e7ed5c4e9f140c1f8b96895ca4fc7e")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://www.amazon.in/")
				.formParam("code", "4171")
				
			.when()
				.post("http://coop.apps.symfonycasts.com/token");
		 
	     System.out.println(response);
	     
		 String token = response.jsonPath().get("access_token");
		 
		 given()
		 		.auth().oauth2(token)
		 		.pathParam("USER_ID", 4171)
		 		
		 .when()
		 		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		 	.then().log().all();	
	}
}

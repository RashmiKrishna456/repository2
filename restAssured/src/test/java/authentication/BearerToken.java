package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class BearerToken {
	
	@Test
	public void authentication(){
		
		baseURI = "https://api.github.com";
		JSONObject jobj = new JSONObject();
		jobj.put("name", "Sdet43App");
		
		given()
		 		.auth()
		 		.oauth2("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")
		 		.body(jobj)
		 		.contentType(ContentType.JSON)
		.when()
				.get("https://api.github.com/")
		.then()
				.assertThat().statusCode(201).log().all();
	}
}

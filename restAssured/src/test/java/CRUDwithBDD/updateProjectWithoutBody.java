package CRUDwithBDD;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class updateProjectWithoutBody {
	@Test
	public void addProject()
	{
		//create json body using json simple
		JSONObject jobj = new JSONObject();
		
		baseURI = "http://localhost";
		port = 8084;
		
		//pre-request for the script
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
			
		//Action
		.when()
			.put("/addProject")
			
		//validation
			.then()
				.assertThat().contentType(ContentType.JSON)
				.assertThat().statusCode(409)
				.assertThat().statusLine("HTTP/1.1 409 ")
				.assertThat().and()
				.log().all();
	}
}

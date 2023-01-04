package requestChaining;

import org.testng.annotations.Test;
import CRUDwithBDD.AddProjectTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class PostAndDeleteProjectTest {
	@Test
	public void postAndDelteTest() 
	{
		baseURI = "http://localhost";
		port = 8084;
		AddProjectTest pojo = new AddProjectTest();
		Response response = given()
								.body(pojo)
								.contentType(ContentType.JSON)
				
		.when()
			.post("/addProject");
		
		String proId = response.jsonPath().get("projectId");
		
		given()
			.pathParam("projectId", proId)
			
		.when()
			.delete("projects/{projectId}")
			
		.then()
			.log().all();
	}
}

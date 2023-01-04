package DfWaystoPost;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class createProjectUsingHashMap {
	@Test
	public void createProjectHashMApTest() 
	{
		HashMap hp = new HashMap();
		hp.put("createdBy", "Kalpana");
		hp.put("projectName", "anything-11");
		hp.put("status", "Created");
		hp.put("teamSize", 10);
		
		given().body(hp)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
			
		.then()
			.assertThat().statusCode(201)
			.assertThat().contentType(ContentType.JSON)
			.log().all();	
	}		
}

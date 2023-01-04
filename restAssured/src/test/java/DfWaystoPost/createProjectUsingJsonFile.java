package DfWaystoPost;

import static io.restassured.RestAssured.*;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class createProjectUsingJsonFile {
	@Test
	public void createProject()
	{
	File file = new File("src/test/resources/CreateDataUsingNotepad.json");
	
	given().body(file)
		.contentType(ContentType.JSON)
		
		.when()
			.post("http://localhost:8084/addProject")
			
		.then()
			.assertThat().statusCode(201)
			.assertThat().contentType(ContentType.JSON)
			.log().all();
	}
}

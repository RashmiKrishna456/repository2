package CRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import GenericLibrary.JavaUtility;
import  static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class UpdateProjectTest {
	@Test
	public void updateProjectTest() 
	{
		/*create json body using json simple*/
		JavaUtility jlib = new JavaUtility();
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Rashmi");
		jobj.put("projectName", "LIMS");
		jobj.put("status", "on going");
		jobj.put("teamsize", 6);
		
		/*prerequest for the script*/
		 given()
		 	.body(jobj)
		 	.contentType(ContentType.JSON)
		 	 
		 //ACTION
		.when() 
			.put("http://localhost:8084/projects/TY_PROJ_615")
			
		//validation
		.then()
	 		.assertThat().contentType(ContentType.JSON)
	 		.assertThat().statusCode(200)
	 		.assertThat().statusLine("HTTP/1.1 200 ")
	 		.log().all();	
	}
}

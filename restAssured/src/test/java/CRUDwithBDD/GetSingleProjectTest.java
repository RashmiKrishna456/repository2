package CRUDwithBDD;

import org.testng.annotations.Test;
import static  io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class GetSingleProjectTest {
	@Test
	public void getSingleProjectTest() 
	{
	 when()
	 	.get("http://localhost:8084/projects/TY_PROJ_210")
	 
	//validation
	 .then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(200)
		.assertThat().statusLine("HTTP/1.1 200 ")
		.assertThat().and()
		.log().all();		
	}
}

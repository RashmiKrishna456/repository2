package authentication;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class basicDigestiveAuth {

	@Test
	public void digestiveAuth()
	{
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		
		.when()
			.get("/login")
			
		.then()
			.assertThat().statusCode(202).log().all();
				
	}

}

package FrameworkCRUDOperation;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import GenericLibrary.BaseClassWithReqSpec;
import GenericLibrary.endPointsLibrary;

public class getAllProjects extends BaseClassWithReqSpec{

	@Test
	public void AllProject() throws Throwable
	{	
		given().spec(requestSpec)
		
		.when()
			.get(endPointsLibrary.getAllProjects)
			
		.then()
			.assertThat()
				.statusCode(200)
				.log().all();
	}
}

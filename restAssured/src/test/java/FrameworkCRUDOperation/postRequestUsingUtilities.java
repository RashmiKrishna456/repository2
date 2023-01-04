package FrameworkCRUDOperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import GenericLibrary.BaseClassWithReqSpec;
import GenericLibrary.endPointsLibrary;
import static io.restassured.RestAssured.*;

public class postRequestUsingUtilities extends BaseClassWithReqSpec{

	@Test
	public void postRequest() throws Throwable
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Rashmi");
		jobj.put("projectName", "LIMS"+jLib.getRandomNumber());
		jobj.put("status", "completed");
		jobj.put("teamSize", 5);
		
		given()
			.spec(requestSpec)
			.body(jobj)
		
		.when()
			.post(endPointsLibrary.createProject)
			
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}
}

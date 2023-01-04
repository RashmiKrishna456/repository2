package End2EndScenario;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import GenericLibrary.BaseClassWithReqSpec;
import GenericLibrary.endPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoUtility.addProjectPojoClass;

public class CreateProjectAndVerifyWithBuilders extends BaseClassWithReqSpec{

	@Test
	public void createAndVerifyWithBuilders() throws Throwable
	{
		//step 1: create project using post()

	addProjectPojoClass pLib = new addProjectPojoClass("C", "LIMSProject"+jLib.getRandomNumber(), "completed", 6);
	
	System.out.println(pLib);
	Response resp = given()
						.body(pLib)
						.contentType(ContentType.JSON)
					.when()
						.post(endPointsLibrary.createProject);
	
//	resp.then().log().all();
	
	//Step 2: Capture the response and retrieve projectID
	
	String expData = rLib.getJsonData(resp, "projectID");
	System.out.println(expData);
	
	//Step 3: Connect to database and verify the project
	
	String query = "select * from projects;";
	String actData = dLib.readDataAndValidate(query, 1, expData);
	System.out.println(actData);
	
	//Step 4: Validate
	
	Assert.assertEquals(expData, actData);
	}
}

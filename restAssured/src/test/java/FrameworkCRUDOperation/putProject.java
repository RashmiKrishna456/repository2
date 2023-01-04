package FrameworkCRUDOperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import GenericLibrary.BaseClassWithReqSpec;
import GenericLibrary.ExcelUtility;
import GenericLibrary.JavaUtility;
import GenericLibrary.endPointsLibrary;
import static io.restassured.RestAssured.*;

public class putProject extends BaseClassWithReqSpec{
	@Test
	public void addProject() throws Throwable 
	{
		/*create json body using json simple*/
		JavaUtility jlib = new JavaUtility();
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Rashmi");
		jobj.put("projectName", "LIMS"+jlib.getRandomNumber());
		jobj.put("status", "created");
		jobj.put("teamsize", 5);
		
		ExcelUtility eLib = new ExcelUtility();
		String proId = eLib.readDataFromExcel("Sheet1", 1, 1);
		
		/*prerequest for the script*/
		 given()
		 .spec(requestSpec)
		 	.body(jobj)
		 	.pathParam("Id", proId)
		 	
		 //ACTION
		 .when()
             .put(endPointsLibrary.updateProject+"{Id}")
             
		//validation
        .then()
			.log().all();	
	}
}



package FrameworkCRUDOperation;

import org.testng.annotations.Test;
import GenericLibrary.BaseClassWithReqSpec;
import GenericLibrary.ExcelUtility;
import GenericLibrary.endPointsLibrary;
import static io.restassured.RestAssured.*;

public class deleteProject extends BaseClassWithReqSpec{
	
	@Test
	public void DeleteProject() throws Throwable
	{
		ExcelUtility eLib = new ExcelUtility();
		String prodId = eLib.readDataFromExcel("Sheet2", 1, 1);
		
		given()
			.spec(requestSpec)
			.pathParam("Id", prodId)
			
		.when()
			.delete(endPointsLibrary.deleteProject+"{Id}")
			
			//validation
			.then()
				.assertThat().log().all();
	}
}

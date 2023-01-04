package FrameworkCRUDOperation;

import org.testng.annotations.Test;
import GenericLibrary.BaseClassWithReqSpec;
import GenericLibrary.ExcelUtility;
import GenericLibrary.endPointsLibrary;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class getSingleProject extends BaseClassWithReqSpec{

	@Test
	public void singleProject() throws Throwable
	{
		ExcelUtility eLib = new ExcelUtility();
		String proId = eLib.readDataFromExcel("Sheet1", 1, 1);
		
		given().pathParam("Id", proId)
		
		.when()
			.get(endPointsLibrary.getSingleProject+"{Id}")
			
		.then()
			.assertThat()
				.log().all();
	}
}

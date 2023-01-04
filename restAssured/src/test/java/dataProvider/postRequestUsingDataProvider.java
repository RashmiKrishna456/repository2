package dataProvider;

import static io.restassured.RestAssured.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import pojoUtility.addProjectPojoClass;

public class postRequestUsingDataProvider {
	
	@Test(dataProvider = "TestBody")
	public void addProjectTest(String createdBy, String projectName, String status, int teamSize) 
	{
		addProjectPojoClass apj=new addProjectPojoClass(createdBy, projectName, status, teamSize);

		given()
			.body(apj)
			.contentType(ContentType.JSON)
		
		.when()
			.post("http://localhost:8084/addProject")
		
		.then()
			.assertThat().contentType(ContentType.JSON)
			.log().all();
	}
	@DataProvider
	public Object[][] TestBody() {
		Object [][] obj = new Object[2][4];
		obj[0][0]="Rashmi";
		obj[0][1]="LIMS";
		obj[0][2]="Created";
		obj[0][3]=12;
		obj[1][0]="Krishna";
		obj[1][1]="HRM";
		obj[1][2]="Created";
		obj[1][3]=13;
		return obj;
	}
}

package paramters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter {
	@Test
	public void QueryparameterTest()
	{
		given()
			.queryParam("page", 2)
			
		.when()
			.get("https://reqres.in/api/users")
			
		.then()
			.log().all();
		//query parameter we dont have to mention in the uri , 
		//it wil automatically take that
	}
}

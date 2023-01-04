package paramters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class pathParameter {
	@Test
	public void pathParameter()
	{
		String proId="TY_PROJ_804";
		
		given()
		.pathParam("projectID", proId)
		
		.when().get("http://localhost:8084/projects/{projectID}")
		
//		.when()
//			.delete("http://localhost:8084/projects/{projectID}")

		.then()
				.assertThat().statusCode(204).log().all();
	}
}

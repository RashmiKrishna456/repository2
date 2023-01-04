package requestSpecificationBuilderPrograms;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class WithoutUsingRequestSpecification {

	@Test
	public void getAllBookings() 
	{
		RestAssured
		.given()
		                .baseUri("https://restful-booker.herokuapp.com")
		                .basePath("/booking")
		.when()
		.then()
						.log().all()
						.statusLine("HTTP/1.1 200 OK");
	}
	
	@Test
	public void getBookingDetailsWithInvalidFirstName() 
	{
		RestAssured
        .given()
        			.baseUri("https://restful-booker.herokuapp.com")
        			.basePath("/booking")
        			.formParam("firstname", "rashmi")
        .when()
        .then()
					.log().all()
					.statusLine("HTTP/1.1 200 OK");
	}
}

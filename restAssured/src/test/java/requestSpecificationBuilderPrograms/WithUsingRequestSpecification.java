package requestSpecificationBuilderPrograms;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class WithUsingRequestSpecification 
{
	RequestSpecification requestSpecification;
	@BeforeClass
	public void setupRequestSpecification() 
	{
		requestSpecification = RestAssured.given()
					.baseUri("https://restful-booker.herokuapp.com")
					.basePath("/booking");
	}

	@Test
	public void getAllBookings() 
	{
		RestAssured
		.given()
						.spec(requestSpecification)
		.when()
		.then()
						.log().all()
						.statusLine("HTTP/1.1 200 OK");
	}
	
	@Test
	public void getBookingDetailsWithInvalidFirstName() {
		RestAssured
		.given()
					.spec(requestSpecification)
					.formParam("firstname", "rashmi")
        .when()
        .then()
					.log().all()
					.statusLine("HTTP/1.1 200 OK");
	}
}

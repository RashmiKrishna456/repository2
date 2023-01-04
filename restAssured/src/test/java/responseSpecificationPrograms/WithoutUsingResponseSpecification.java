package responseSpecificationPrograms;

import java.util.concurrent.TimeUnit;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class WithoutUsingResponseSpecification {

	@Test
	public void getAllBookings() 
	{
		RestAssured
		.given()
					.baseUri("https://restful-booker.herokuapp.com")
		.when()
					.get("/booking")
		.then()
					.contentType(ContentType.JSON)
					.statusLine("HTTP/1.1 200 OK")
					.statusCode(200)
					.time(Matchers.lessThan(5000l), TimeUnit.MILLISECONDS)
					.body("size()", Matchers.greaterThan(5));
					
	}
	
	@Test
	public void getBookingDetailsWithInvalidFirstName() 
	{
		RestAssured
		.given()
					.baseUri("https://restful-booker.herokuapp.com")
		.when()
					.get("/booking?firstname=rashmi")
		.then()
					.contentType(ContentType.JSON)
					.statusLine("HTTP/1.1 200 OK")
					.statusCode(200)
					.time(Matchers.lessThan(5000l), TimeUnit.MILLISECONDS)
					.body("size()", Matchers.equalTo(0));
	}
}
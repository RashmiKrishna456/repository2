package responseSpecificationPrograms;

import java.util.concurrent.TimeUnit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class UsingResponseSpecification {

	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void setupResponseSpecification() 
	{
		responseSpecification = RestAssured.expect();
		responseSpecification.contentType(ContentType.JSON);
		responseSpecification.statusCode(200);
		responseSpecification.statusLine("HTTP/1.1 200 ");
		responseSpecification.time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void getAllBookings() 
	{
		RestAssured
		.given()
				.baseUri("https://restful-booker.herokuapp.com")
		.when()
				.get("/booking")
		.then()
				.spec(responseSpecification)
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
				.spec(responseSpecification)
				.body("size()", Matchers.equalTo(0));
	}
}

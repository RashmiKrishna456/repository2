package requestSpecificationBuilderPrograms;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationWithMethod {

	@Test
	public void specification() 
	{
		// Creating request specification using given()
		RequestSpecification request1 = RestAssured.given();
		request1.baseUri("https://restful-booker.herokuapp.com");	//setting base uri
		request1.basePath("/booking");								//setting base path
		
		// Creating request specification using with()
		RequestSpecification request2 = RestAssured.with();
		request2.baseUri("https://restful-booker.herokuapp.com");	//setting base uri
		request2.basePath("/booking");								//setting base path
		
		RequestSpecification request3 = RestAssured.given();
		request3.baseUri("https://restful-booker.herokuapp.com").basePath("/booking");
		
		RequestSpecification request4 = RestAssured.with();
		request4.baseUri("https://restful-booker.herokuapp.com").basePath("/booking");
	}
}

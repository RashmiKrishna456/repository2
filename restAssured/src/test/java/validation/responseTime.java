package validation;

import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class responseTime {

	@Test
	public void responsetime()
	{
		//pre-requisites
		baseURI = "http://localhost";
		port = 8084;
		
		//action
		when()
			.get("/projects")
			
		//validation
		.then()
			.assertThat().time(Matchers.lessThan(6000L), TimeUnit.MILLISECONDS)
			.log().all();
		
	}
}

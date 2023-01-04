package interviewQuestions;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class uploadMultipartFile {
	@Test
	public void uploadFile()
	{
		File testUploadFile = new File("D:\\RASHMI\\LIMS_Workspace\\restAssured\\src\\test\\resources\\deg.jpg");

		baseURI = "http://localhost";
		port = 8084;

		 Response response = given().multiPart(testUploadFile)
				 			.when()
			 					.post("/addProject");

		 System.out.println(response.getStatusCode());
		 System.out.println(response.asString());

		 assertTrue(response.asString().contains("successfully uploaded"));
	}
}

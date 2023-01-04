package interviewQuestions;

import java.io.File;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class uploadImageTestWithoutBDD {

	@Test
	public void uploadImage()
	{
		File file = new File("D:\\RASHMI\\LIMS_Workspace\\restAssured\\src\\test\\resources\\deg.jpg");
		
		Response response = RestAssured
				.given()
					.multiPart("file", file, "multipart/form-data")
					.post("https://the-internet.herokuapp.com/upload")
					.thenReturn();
		
				response.prettyPrint();
//				System.out.println(response.prettyPrint());		
	}
}

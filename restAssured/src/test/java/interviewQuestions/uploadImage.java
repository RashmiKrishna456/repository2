package interviewQuestions;

import java.io.File;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class uploadImage {
	@Test
	public void fileUpload()
	{
		File file = new File("/restAssured/src/test/resources/deg.jpg");
		
		given().multiPart("file", file, "multipart/form-data")
		.post("https://the-internet.herokuapp.com/upload")
		.thenReturn().then().log().all();
	}
}

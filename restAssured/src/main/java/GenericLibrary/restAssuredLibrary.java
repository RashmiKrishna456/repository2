package GenericLibrary;

import io.restassured.response.Response;

public class restAssuredLibrary {

	/**
	 *Consists of methods of RestAssured tool
	 */
	public String getJsonData(Response response, String path)
	{
		/**
		 * This method will return json data from the corresponding response body
		 */
		String jsonData = response.jsonPath().get(path);
		return jsonData;
	}
}

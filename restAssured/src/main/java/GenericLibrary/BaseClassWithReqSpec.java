package GenericLibrary;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClassWithReqSpec {

	public JavaUtility jLib = new JavaUtility();
	public restAssuredLibrary rLib = new restAssuredLibrary();
	public DataBaseUtility dLib = new DataBaseUtility();
	public RequestSpecification requestSpec;
	public ResponseSpecification responseSpec;
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		dLib.connectToDB();
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://localhost");
		builder.setPort(8084);
		builder.setContentType(ContentType.JSON);
		requestSpec = builder.build();
	}
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.close();
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		responseSpec = builder.expectContentType(ContentType.JSON).build();
	}
}

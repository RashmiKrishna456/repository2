package TestYanta.restAssured;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import serializationAndDeSerialization.EmployeeDetailsPojo;

public class deSerializationOfEmpDetails {
	
	@Test
	public void deSerializationOfEmployeeDetails() throws Throwable
	{
		//step1:- create the object for object mapper
		ObjectMapper objm = new ObjectMapper();
		
		//step1:- read the value from the object mapper
		EmployeeDetailsPojo e = objm.readValue(new File("./empdata.json"), EmployeeDetailsPojo.class);
		
		//fetch the required value
		System.out.println(e.getEname());
		System.out.println(e.getEmail());
	}

}

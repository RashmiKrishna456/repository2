package TestYanta.restAssured;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import serializationAndDeSerialization.EmployeeDetailsPojo;

public class serializationOfEmpDetails {

	@Test
	public void serializationOfEmployeeDetails() throws Throwable
	{
		//create the object for pojo class
		EmployeeDetailsPojo empj = new EmployeeDetailsPojo("Rashmi", "4346", "rashmikrishna062@gmail.com", 92462, "Mysore");
		
		//create the object for Object mapper
		ObjectMapper objm = new ObjectMapper();
		
		//write the value to json file
		objm.writeValue(new File("./empdata.json"), empj);
	}
}

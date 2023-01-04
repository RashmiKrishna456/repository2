package TestYanta.restAssured;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import serializationAndDeSerialization.EmployeeDetailsWithObject;

public class serializationOfEmpDetailsWithObject {
@Test
public void serializationOfEmployeeDetailsWithObject() throws Throwable
{
//	Spouse sp = new Spouse("xyz", "xyz@gmail.com", 1234, "Bandipur");

	String[] email =  {"rashmi@gmail.com", "abc@gmail.com"};
	int[] phoneNo = {1245, 4578};
	EmployeeDetailsWithObject empob = new EmployeeDetailsWithObject("Rash", "1562", email, phoneNo, "Mysore");
	
	ObjectMapper objm = new ObjectMapper();
	
	objm.writeValue(new File("./EmpDataWithObject.json"), empob);
	
}
}

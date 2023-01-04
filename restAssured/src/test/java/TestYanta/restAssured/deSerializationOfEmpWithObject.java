package TestYanta.restAssured;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import serializationAndDeSerialization.EmployeeDetailsWithArray;
import serializationAndDeSerialization.EmployeeDetailsWithObject;

public class deSerializationOfEmpWithObject {

	@Test
	public void deSerializationOfEmployeeWithObject() throws Throwable
	{
		//step1:- create the object for object mapper
		ObjectMapper objm = new ObjectMapper();
		
		//step1:- read the value from the object mapper
		EmployeeDetailsWithObject e = objm.readValue(new File("./EmpDataWithObject.json"), EmployeeDetailsWithObject.class);
		
		//fetch the required value
		System.out.println(e.getEname());
		System.out.println(e.getAddress());
		
		String[] em = e.getEmail();		
		for(int i=0; i<em.length; i++)   //for each mail, print
		{
			System.out.println(em[i]);   //to print email's in an array
		}
		
		int[] ph = e.getPhoneNo();
		for(int i=0; i<ph.length; i++)   //for each phoneNo, print
		{
			System.out.println(ph[i]);   //to print phoneNo's in an array
		}
		
		//spouse object need to be de-serialized
	}

}

package serializationAndDeSerialization;

public class EmployeeDetailsWithArray {

		//Declare the variable globally
		String Ename;
		String Eid;
		String[] Email; //String array
		int[] PhoneNo; //int array
		String Address;
		
		//create the constructor for initialization
		public EmployeeDetailsWithArray(String ename, String eid, String[] email, int[] phoneNo, String address) {
			super();
			Ename = ename;
			Eid = eid;
			Email = email;
			PhoneNo = phoneNo;
			Address = address;
		}
		
		public EmployeeDetailsWithArray() //constructor for Deserialization
		{
			
		}
		
		//setters and getters for access

		public String getEname() {
			return Ename;
		}

		public void setEname(String ename) {
			Ename = ename;
		}

		public String getEid() {
			return Eid;
		}

		public void setEid(String eid) {
			Eid = eid;
		}

		public String[] getEmail() {
			return Email;
		}

		public void setEmail(String[] email) {
			Email = email;
		}

		public int[] getPhoneNo() {
			return PhoneNo;
		}

		public void setPhoneNo(int[] phoneNo) {
			PhoneNo = phoneNo;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}
		
}

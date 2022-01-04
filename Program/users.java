import java.util.*;

abstract class users
{
	public String Username;
	private String Password;
	protected char mode;
	static int chooseusername()
	{
		return 0;
	}
	abstract public void SignUp();
	abstract public void LogIn();

}

class Faculty extends users
{
	public String Faculty_ID;
	public String Full_Name;
	public String MobileNo;
	public String Email;
	public String Designation;
	public String Department;
	public String School_Campus;
	public void LogIn()
	{
		
	}
	public void SignUp()
	{
		
	}
	
}
class Admin extends users
{
	public String Admin_ID;
	public String MobileNo;
	public String Email;
	public String Department;
	public String School_Campus;
	public void LogIn()
	{
		
	}
	public void SignUp()
	{
		
	}
	
}


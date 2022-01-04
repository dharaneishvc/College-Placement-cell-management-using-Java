class Company
{
	public int Company_ID;
	public String Company_name;
	public String Website;
}
class Jobs
{
	public Company Companylink;
	public int Job_ID;
	public String role;
	public String[] Eligible_Branches;
	public String[] Qualifications;
	public int no_of_hirings;
}
class Placements
{
	public String Roll_No;
	public int Job_ID;
	public Date Date_placed; //read date and time object
}

public class Company {

    public String Company_Name;
    public String Company_ID;
    public String Company_Description;
    public String Company_Type;
    public String Company_Address;

    public Company(String company_Name, String company_ID, String company_Description, String company_Type, String company_Address) {
        Company_Name = company_Name;
        Company_ID = company_ID;
        Company_Description = company_Description;
        Company_Type = company_Type;
        Company_Address = company_Address;
    }

    public String getCompany_Address() {
        return Company_Address;
    }

    public void setCompany_Address(String company_Address) {
        Company_Address = company_Address;
    }

    public String getCompany_Name() {
        return Company_Name;
    }

    public void setCompany_Name(String company_Name) {
        Company_Name = company_Name;
    }

    public String getCompany_ID() {
        return Company_ID;
    }

    public void setCompany_ID(String company_ID) {
        Company_ID = company_ID;
    }

    public String getCompany_Description() {
        return Company_Description;
    }

    public void setCompany_Description(String company_Description) {
        Company_Description = company_Description;
    }

    public String getCompany_Type() {
        return Company_Type;
    }

    public void setCompany_Type(String company_Type) {
        Company_Type = company_Type;
    }

    @Override
    public String toString() {
        return "Company{" +
                "Company_Name='" + Company_Name + '\'' +
                ", Company_ID='" + Company_ID + '\'' +
                ", Company_Description='" + Company_Description + '\'' +
                ", Company_Type='" + Company_Type + '\'' +
                ", Company_Address='" + Company_Address + '\'' +
                '}';
    }
}

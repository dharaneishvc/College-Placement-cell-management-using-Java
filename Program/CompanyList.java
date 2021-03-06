import java.util.ArrayList;
import java.util.List;

public class CompanyList extends Lists
{
   List<Company> companies= new ArrayList<>();

   public void addCompany(Company company)
   {
       companies.add(company);
   }

   public void removeCompany(Company company)
   {
       companies.remove(company);
   }

    public void printCompanies()
    {
        if ((companies.size())==0)
        {
            System.out.println("No Companies Found");
        }else {
            for(Company company : companies)
            {
                System.out.println(company.toString());
            }
        }
    }

    public void removeCompany(String companyID)
    {
        int a=0;
        for (Company company : companies)
        { 
            if(company.getCompany_ID().equals(companyID))
            {
                companies.remove(company);
                System.out.println("Company Deleted successfully");
                a=1;
                break;
            }
        }
        if(a==0)
        System.out.println("Company Not Found");
    }

    public Company getCompany(String companyID)
    {
        for(Company company : companies)
        {
            if(company.getCompany_ID().equals(companyID))
            {
                return company;
            }
        }
        return null;
    }

    public  int searchCompany(String companyID)
    {
        int a=0;
        for (Company company : companies)
        {
            if(company.getCompany_ID().equals(companyID))
            {
                a=1;
                break;
            }
        }
        if(a==0)
        {
            System.out.println("Company Not Found");
        }
        return a;
    }

    public boolean checkCompany(String companyname)
    {
        for(Company company : companies)
        {
            if(company.getCompany_Name().equals(companyname))
            {
                return true;
            }
        }
        return false;
    }

    public void updateCompany(String companyID, String companyName, String companyAddress)
    {
        int a=0;
        for(Company company : companies)
        {
            if(company.getCompany_ID().equals(companyID))
            {
                company.setCompany_Name(companyName);
                company.setCompany_Address(companyAddress);
                System.out.println("Company Updated successfully");
                a=1;
                break;
            }
        }
        if(a==0)
        {
            System.out.println("Company Not Found");
        }
    }

   public List<Company> getCompanies()
   {
       return companies;
   }

   public Company getCompany(int index)
   {
       return companies.get(index);
   }

   public int getCompanyCount()
   {
       return companies.size();
   }

   public int getSize()
   {
       return companies.size();
   }

   public void printCompany(String name)
   {
       for(Company company : companies)
       {
           if(company.getCompany_Name().equals(name))
           {
               System.out.println(company);
           }
       }
   }


public void clear() {
    companies.clear();
}

public boolean isEmpty() {
    return companies.isEmpty();
}

}
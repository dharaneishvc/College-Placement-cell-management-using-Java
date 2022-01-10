import java.util.ArrayList;
import java.util.List;

public class CompanyList
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
        for(Company company : companies)
        {
            System.out.println(company.toString());
        }
    }


    public void removeCompany(String companyID)
    {
        for (Company company : companies)
        {
            if(company.getCompany_ID().equals(companyID))
            {
                companies.remove(company);
                break;
            }
        }
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
        for(Company company : companies)
        {
            if(company.getCompany_ID().equals(companyID))
            {
                company.setCompany_Name(companyName);
                company.setCompany_Address(companyAddress);
                break;
            }
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
}


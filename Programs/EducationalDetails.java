import java.util.Scanner;

public class EducationalDetails {

    public String department;
    public String branch;
    public String yearOfStudy;
    public double cgpa;
    public String section;
    public double tenthPercentage;
    public double twelvethPercentage;


    public EducationalDetails(String department, String branch, String yearOfStudy, double cgpa, String section, double tenthPercentage, double twelvethPercentage) {

        this.department = department;
        this.branch = branch;
        this.yearOfStudy = yearOfStudy;
        this.cgpa = cgpa;
        this.section = section;
        this.tenthPercentage = tenthPercentage;
        this.twelvethPercentage = twelvethPercentage;
    }

    public EducationalDetails() {

    }

    @Override
    public String toString() {
        return "EducationalDetails{" +
                "department='" + department + '\'' +
                ", branch='" + branch + '\'' +
                ", yearOfStudy='" + yearOfStudy + '\'' +
                ", cgpa=" + cgpa +
                ", section='" + section + '\'' +
                ", tenthPercentage=" + tenthPercentage +
                ", twelvethPercentage=" + twelvethPercentage +
                '}';
    }

    public void editEducationalDetails(int choice)
    {
        Scanner sc = new Scanner(System.in);
        switch(choice)
        {
            case 1:
                System.out.println("Enter the department");
                department = sc.nextLine();
                break;
            case 2:
                System.out.println("Enter the branch");
                branch = sc.nextLine();
                break;
            case 3:
                System.out.println("Enter the year of study");
                yearOfStudy = sc.nextLine();
                break;
            case 4:
                System.out.println("Enter the cgpa");
                cgpa = sc.nextDouble();
                break;
            case 5:
                System.out.println("Enter the section");
                section = sc.nextLine();
                break;
            case 6:
                System.out.println("Enter the tenth percentage");
                tenthPercentage = sc.nextDouble();
                break;
            case 7:
                System.out.println("Enter the twelveth percentage");
                twelvethPercentage = sc.nextDouble();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        sc.close();
    }
}

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Register register = new Register();
        EducationalDetails ed = new EducationalDetails();
        PersonalDetails pd = new PersonalDetails();
        User user = new User();
        JobList jobList = new JobList();
        CompanyList companyList = new CompanyList();
        Login lgn = new Login(register.getRollNumber(), register.getPassword());
            try {
                FileReader file = new FileReader(new File("input.txt"));
                Scanner scan = new Scanner(file);
                while (scan.hasNextLine()) {
                    String username = scan.nextLine();
                    String password = scan.nextLine();
                    Login login = new Login(username, password);
                    lgn.addUser(login);
                }
                scan.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
        }
        int choice = 0;               
        while(choice!=4) {
            System.out.println("Welcome to Placement Support System");
            System.out.println("Enter 1 - if you are a New User \nEnter 2 - if you are an Existing User \nEnter 3 - if you are an Admin \nEnter 4 - if you want to exit");
            Scanner sc = new Scanner(System.in);
            try
            {
                choice = sc.nextInt();
            } 
            catch(Exception e)
            {
                System.out.println("Some exception occurred. Value Not Integer" + e);
            }
            while(choice<1 || choice>4)
            {
                System.out.println("Error.. Wrong Input. Enter value between (1-4):");
                choice = sc.nextInt();
            }
            if (choice == 1) {
                String rollNumber, name, email, mobile;
                try
                {
                    do {
                        System.out.println("Enter your College Roll Number");
                        System.out.println("Enter your Unique Roll Number and duplicate accounts will not be allowed");
                        rollNumber = sc.next();
                    } while (lgn.checkusername(rollNumber));
                    sc.nextLine();
                System.out.println("Enter your Name");
                name = sc.nextLine();
                    do {
                        System.out.println("Enter your email");
                        System.out.println("Enter a valid email and duplicate accounts will not be allowed");
                        email = sc.next();
                    } while (!Register.isEmValid(email));
                    do {
                        System.out.println("Enter your mobile number(country code+10digits)");
                        System.out.println("Enter a valid mobile number and duplicate accounts will not be allowed");
                        mobile = sc.next();
                    } while (!Register.isPhValid(mobile));
                    sc.nextLine();
                register = new Register(rollNumber, name, email, mobile);
                }
                catch(Exception e)
                {
                    System.out.println("Type mismatch or any other exception" + e+" Action Aborted.");
                }
                {
                    do{
                        try
                        {
                        System.out.println("Enter your password.(Press enter at last):");
                        String password = sc.nextLine();
                        register.setPassword(password);
                        System.out.println("Enter your password again.(Press enter at last):");
                        String passwordAgain = sc.nextLine();
                        register.setPasswordAgain(passwordAgain);
                        }
                        catch(Exception e)
                        {
                            System.out.println("Some error in Input of Passwords. Aborting");
                        }
                        if (register.getPassword().equals(register.getPasswordAgain())) {
                            System.out.println("Your password has been set");
                            System.out.println("Your College Roll Number will act as your Username");
                            break;
                        } else {
                            System.out.println("Your passwords do not match");
                        }
                    }while(true);
                    User user1 = new User(register.getRollNumber(),register.getPassword());
                    lgn.addUser(user1);
                }

                System.out.println("Do you want to enter your personal details? \nEnter 1 if you want to enter your personal details");
                int choice1 = sc.nextInt();
                if (choice1 == 1) {
                    try
                    {
                    sc.nextLine();
                    System.out.println("Enter your Father's Name");
                    String fatherName = sc.nextLine();
                    System.out.println("Enter your Mother's Name");
                    String motherName = sc.nextLine();
                    System.out.println("Enter your Date of Birth");
                    String dateOfBirth = sc.next();
                    sc.nextLine();
                    System.out.println("Enter your Address");
                    String address = sc.nextLine();
                    System.out.println("Enter your City");
                    String city = sc.nextLine();
                    System.out.println("Enter your State");
                    String state = sc.nextLine();
                    System.out.println("Enter your Country");
                    String country = sc.nextLine();
                    System.out.println("Enter your Pincode");
                    String pinCode = sc.nextLine();
                    pd = new PersonalDetails(fatherName, motherName, dateOfBirth, address, city, state, country, pinCode);
                    }
                    catch(Exception e)
                    {
                    System.out.println("Type mismatch or other Exception."+e+" Action Aborted.");
                    }
                }
                System.out.println("Do you want to enter your Educational details? \nEnter 1 - if you want to enter your educational details ");
                int choice2 = sc.nextInt();
                sc.nextLine();
                if (choice2 == 1) {
                    try
                    {
                    System.out.println("Enter your Department");
                    String department = sc.nextLine();
                    System.out.println("Enter your Branch");
                    String branch = sc.nextLine();
                    System.out.println("Enter your Year of Study");
                    String yearOfStudy = sc.nextLine();
                    System.out.println("Enter your CGPA");
                    double cgpa = sc.nextDouble();
                    System.out.println("Enter your Section");
                    String section = sc.next();
                    System.out.println("Enter your 10th Percentage");
                    double tenthPercentage = sc.nextDouble();
                    System.out.println("Enter your 12th Percentage");
                    double twelvethPercentage = sc.nextDouble();
                    ed = new EducationalDetails(department, branch, yearOfStudy, cgpa, section, tenthPercentage, twelvethPercentage);
                    }
                    catch(Exception e)
                    {
                    System.out.println("Type mismatch or other Exception."+e+" Action Aborted.");
                    }
                    System.out.println("Registered Successfully. Log In to access.");
                }

            } else if (choice == 2) {
                lgn.readCredentials();
                if (lgn.checkCredentials()) {
                    lgn.printLoggedInUser();
                    Student student = new Student(pd, ed, register, user);
                    int choice3=0;
                    while(choice3 != 8) {
                        System.out.println("Enter 1 to Edit your details\nEnter 2 to See List of Job Opportunities\nEnter 3 to Add Job to Application \nEnter 4 to Remove Job from Application  \nEnter 5 to View Your Job Applications \nEnter 6 to View Companies \nEnter 7 to print applied jobs \nEnter 8 to Logout");
                        try{
                            choice3 = sc.nextInt();
                        }
                        catch(Exception e)
                        {
                            System.out.println("Some exception occured"+e);
                            choice3=8;
                            continue;
                        }

                        while(choice3>8 || choice3<1)
                        {
                            System.out.println("Error. Enter correct value (1-7):");
                            choice3 = sc.nextInt();
                        }
                        if (choice3 == 1) {
                            System.out.println("Enter 1 to View your details\n Enter 2 to Edit your personal details\n Enter 3 to Edit your educational details\n Enter 4 to Reset your password");
                            int choice4 = sc.nextInt();
                            switch (choice4) {
                                case 1:
                                    System.out.println("Details of Students \n");
                                    student.showPersonalDetails();
                                    student.showEducationalDetails();
                                    break;
                                case 2:
                                    student.showPersonalDetails();
                                    System.out.println("Enter 1 to Edit your Father's Name\nEnter 2 to Edit your Mother's Name\nEnter 3 to Edit your Date of Birth\nEnter 4 to Edit your Address\nEnter 5 to Edit your City\nEnter 6 to Edit your State\nEnter 7 to Edit your Country\nEnter 8 to Edit your Pincode");
                                    try
                                    {   
                                        int choice5 = sc.nextInt();
                                        student.editPersonalDetails(choice5);
                                        break;
                                    }
                                    catch(Exception e)
                                    {
                                        System.out.println("Type mismatch or Some Exception happened. Aborting"+e);
                                        break;
                                    }
                                    
                                case 3:
                                    student.showEducationalDetails();
                                    System.out.println("Enter 1 to Edit your Department\nEnter 2 to Edit your Branch\nEnter 3 to Edit your Year of Study\nEnter 4 to Edit your CGPA\nEnter 5 to Edit your Section\nEnter 6 to Edit your 10th Percentage\nEnter 7 to Edit your 12th Percentage");
                                    try
                                    {
                                    int choice6 = sc.nextInt();
                                    student.editEducationalDetails(choice6);
                                    break;
                                    }
                                    catch(Exception e)
                                    {
                                        System.out.println("Type mismatch or Some Exception happened. Aborting"+e);
                                        break;
                                    }
                                case 4:
                                    student.resetPassword();
                                    break;
                                default:
                                    System.out.println("Wrong Choice! Redirecting to Main menu.");
                            }
                        } else if (choice3 == 2) {
                            jobList.printjobs();
                        }
                        else  if(choice3==3){
                            jobList.printjobs();
                            System.out.println("Enter the Job ID you want to add to your Job Application");
                            try
                            {
                            int jobId1 =sc.nextInt();
                            Jobs job1=jobList.getJob(jobId1);
                            if(job1 != null)
                            student.addJob(job1);
                            else
                            System.out.println("Job Not Found");
                            }
                            catch(Exception e)
                            {
                                System.out.println("Type mismatch or Some Exception happened. Aborting"+e);
                            }
                        }
                        else if(choice3==4){
                            System.out.println("Enter the Job ID you want to remove from your Job Application");
                        try{    
                            int jobId2 =sc.nextInt();
                            Jobs job2=jobList.getJob(jobId2);
                            student.removeJob(job2);
                        }
                        catch(Exception e)
                        {
                            System.out.println("Type mismatch or Some Exception happened. Aborting"+e);
                        }
                        }
                        else  if(choice3 == 5){
//
                            student.print_jobs();
                        }
                        else if(choice3 == 6){
                            companyList.printCompanies();
                        }
                        else if(choice3 == 7){
                            try {
                                FileWriter fw = new FileWriter("Jobs.txt");
                                BufferedWriter bw = new BufferedWriter(fw);
                                for(int i=0;i<student.jobs.size();i++) {
                                    bw.write(student.jobs.get(i).toString());
                                } bw.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        else if(choice3 == 8){
                            System.out.println("Logged Out Successfully");
                            break;
                        }
                    }
                } else {
                    System.out.println("Invalid Credentials");
                }
            } else if (choice == 3) {
                lgn.readCredentials();
                if (lgn.checkCredentials() && lgn.admincheck()) {
                    lgn.printLoggedInUser();
                    int choice4=0;
                    while(choice4 != 11) {
                        System.out.println("Enter 1 to view and print Encoded Users List \nEnter 2 to view Job Lists \nEnter 3 to view Company Lists \nEnter 4 to Add Job \nEnter 5 to Add Company \nEnter 6 to Remove Job \nEnter 7 to Remove Company \nEnter 8 to Update Company \nEnter 9 to Update Job \nEnter 10 for Advanced options \nEnter 11 to Logout");
                        try
                        {
                            choice4 = sc.nextInt();
                            while((choice4 > 11) || choice4 < 1)
                            {
                                System.out.println("Error! Enter correct value(1-8):");
                                choice4 = sc.nextInt();
                            }
                        if (choice4 == 1) {
                            FileOutputStream fos = new FileOutputStream("Users.txt");
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(lgn.listOfUsers);
                            oos.close();
                            fos.close();
                            System.out.println("Users List Printed Successfully");
                            lgn.printListOfUsers();
                        } else if (choice4 == 2) {
                            jobList.printjobs();
                        } else if (choice4 == 3) {
                            companyList.printCompanies();
                        } else if (choice4 == 4) {
                            try
                            {
                            sc.nextLine();
                            System.out.println("Enter the Job Title");
                            String jobTitle = sc.nextLine();
                            System.out.println("Enter the Job Description");
                            String jobDescription = sc.nextLine();
                            System.out.println("Enter the Job Location");
                            String jobLocation = sc.nextLine();
                            System.out.println("Enter the Job Salary");
                            float jobSalary = sc.nextFloat();
                            System.out.println("Enter the Job Experience(years whole num)");
                            int jobExperience = sc.nextInt();
                            System.out.println("Enter the Job ID");
                            int Job_ID = sc.nextInt();
                            System.out.println("Enter the Job Type(Int):");
                            int jobType = sc.nextInt();
                            System.out.println("Enter Job Status(Boolean):");
                            boolean jobStatus = sc.nextBoolean();
                            Jobs job = new Jobs(jobTitle, jobSalary, Job_ID, jobExperience, jobType, jobStatus, jobLocation, jobDescription);
                            jobList.add(job);
                            }
                            catch(Exception e)
                            {
                                System.out.println("Type Mismatch or any other kind of exception" + e + "Action Aborted");
                            }

                        } else if (choice4 == 5) {
                            try
                            {
                            sc.nextLine();
                            System.out.println("Enter the Company Name");
                            String companyName = sc.nextLine();
                            System.out.println("Enter the Company Description");
                            String companyDescription = sc.nextLine();
                            System.out.println("Enter the Company ID");
                            String companyID = sc.next();
                            sc.nextLine();
                            System.out.println("Enter the Company Type");
                            String companytype = sc.nextLine();
                            System.out.println("Enter the Company Address");
                            String companyAddress = sc.nextLine();
                            Company company = new Company(companyName, companyID, companyDescription, companytype, companyAddress);
                            companyList.addCompany(company);
                            }
                            catch(Exception e)
                            {
                                System.out.println("Type Mismatch or any other kind of exception" + e);
                            }
                        }
                        else if (choice4 == 6) {
                            System.out.println("Enter the Job ID");
                            int jobID = sc.nextInt();
                            if (jobList.searchJob(jobID) == 0) {
                                continue;
                            }
                            else {
                                jobList.removeJob(jobID);
                            }
                        }
                        else if (choice4 == 7) {
                            System.out.println("Enter the Company ID");
                            String companyID = sc.next();
                            if (companyList.searchCompany(companyID) == 0) {
                                continue;
                            }
                            else {
                                companyList.removeCompany(companyID);
                            }
                        }
                        else  if (choice4==8)
                        {
                            System.out.println("Enter the Company ID of the Company");
                            String companyID = sc.next();
                            if(companyList.searchCompany(companyID)==0)
                            {
                                System.out.println("Company not found");
                                System.out.println("Try Again with Correct Company ID");
                            }
                            else{
                                sc.nextLine();
                                System.out.println("Enter the Updated Company Name");
                                String companyName = sc.nextLine();
                                System.out.println("Enter the Updated Company Address");
                                String companyAddress = sc.nextLine();
                                companyList.updateCompany(companyID,companyName,companyAddress);
                            }
                        }
                        else if (choice4==9)
                        {
                            System.out.println("Enter the Job ID of the Job");
                            int jobID = sc.nextInt();
                            if(jobList.searchJob(jobID)==0)
                            {
                                System.out.println("Job not found");
                                System.out.println("Try Again with Correct Job ID");
                            }
                            else {
                                sc.nextLine();
                                System.out.println("Enter the Updated Job Title");
                                String jobTitle = sc.nextLine();
                                System.out.println("Enter the Updated Job Description");
                                String jobDescription = sc.nextLine();
                                System.out.println("Enter the Updated Job Location");
                                String jobLocation = sc.nextLine();
                                System.out.println("Enter the Updated Job Salary");
                                float jobSalary = sc.nextFloat();
                                System.out.println("Enter the Updated Job Experience");
                                int jobExperience = sc.nextInt();
                                System.out.println("Enter the Updated Job Type");
                                int jobType = sc.nextInt();
                                jobList.updateJob(jobID,jobTitle,jobDescription,jobLocation,jobType,jobSalary,jobExperience);
                            }
                        }
                        else if(choice4 == 10)
                        {
                            System.out.println(" Enter 1 to view No of Jobs and Companies added \n Enter 2 to check IsEmpty of companies and Jobs data \n Enter 3 to clear Job data \n Enter 4 to clear Company Data \n Enter 5 to Quit");
                            int c = sc.nextInt();
                            while(c >5 || c<1)
                            {
                                System.out.println("Invalid Input. Enter Correct value(1-5) again.");
                                c = sc.nextInt();
                            }
                            if(c==1)
                            {
                                System.out.println("Size of Company: "+ companyList.getSize() );
                                System.out.println("Size of Job: "+ jobList.getSize() );
                            }
                            else if(c==2)
                            {
                                if(companyList.isEmpty())
                                {
                                    System.out.println("Company is Empty");
                                }
                                else
                                {
                                    System.out.println("Company is not Empty");
                                }
                                if(jobList.isEmpty())
                                {
                                    System.out.println("Job is Empty");
                                }
                                else
                                {
                                    System.out.println("Job is not Empty");
                                }
                            }
                            else if(c==3)
                            {
                                System.out.println("This will clear all Jobs. Are you sure you want to clear?(y/n)");
                                char ch = sc.next().charAt(0);
                                if(ch=='y' || ch=='Y')
                                {
                                    jobList.clear();
                                    System.out.println("Cleared Successfully");
                                }
                                else
                                {
                                    System.out.println("Data not cleared");
                                }
                            }
                            else if(c==4)
                            {
                                char ch = sc.next().charAt(0);
                                if(ch=='y' || ch=='Y')
                                {
                                    companyList.clear();
                                    System.out.println("Cleared Successfully");
                                }
                                else
                                {
                                    System.out.println("Data not cleared");
                                }
                           }
                           else
                           {
                               System.out.println("Quitting");
                           }
                        }
                        else if (choice4 == 11) {
                            System.out.println("Logged Out Successfully");
                            break;
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Type mismatch or Some Exception happened. Aborting"+e);
                    }

                    }
                }
                else
                {
                    System.out.println("Wrong Username or Password");
                }
            }
            else if(choice==4){
                System.out.println("Thank You for Using.");
                System.exit(0);
                sc.close();
            }
        }
    }
}


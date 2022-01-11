import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
    
        Register register = new Register();
        EducationalDetails ed = new EducationalDetails();
        PersonalDetails pd = new PersonalDetails();
        User user = new User();
        JobList jobList = new JobList();
        CompanyList companyList = new CompanyList();
        Login lgn = new Login(register.getRollNumber(), register.getPassword());
        
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
                System.out.println("Error. Wrong Input. Enter value bw (1-4):");
                choice = sc.nextInt();
            }
            if (choice == 1) {
                String rollNumber, name, email, mobile;
                try
                {
                System.out.println("Enter your College Roll Number");
                rollNumber = sc.next();
                sc.nextLine();
                System.out.println("Enter your Name");
                name = sc.nextLine();
                System.out.println("Enter your email");
                email = sc.next();
                System.out.println("Enter your mobile number");
                mobile = sc.next();
                sc.nextLine();
                register = new Register(rollNumber, name, email, mobile);
                }
                catch(Exception e)
                {
                    System.out.println("Type mismatch or any other exception" + e+" Action Aborted.");
                }
                {
                    do {
                        System.out.println("Enter your password.(Press enter at last):");
                        String password = sc.nextLine();
                        register.setPassword(password);
                        System.out.println("Enter your password again.(Press enter at last):");
                        String passwordAgain = sc.nextLine();
                        register.setPasswordAgain(passwordAgain);
                        if (register.getPassword().equals(register.getPasswordAgain())) {
                            System.out.println("Your password has been set");
                            System.out.println("Your College Roll Number will act as your Username");
                            break;
                        } else {
                            System.out.println("Your passwords do not match");
                        }
                    } while (true);
                    User user1 = new User(register.getRollNumber(),register.getPassword());
                    lgn.addUser(user1);
                }

                System.out.println("Do you want to enter your personal details? \nEnter 1 if you want to enter your personal details \n");
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
                }

            } else if (choice == 2) {
                lgn.printListOfUsers();
                lgn.readCredentials();
                if (lgn.checkCredentials()) {
                    lgn.printLoggedInUser();
                    Student student = new Student(pd, ed, register, user);
                    do {
                        System.out.println("Enter 1 to Edit your details\nEnter 2 to See List of Job Opportunities\nEnter 3 to Add Job to Application \nEnter 4 to Remove Job from Application  \nEnter 5 to View Your Job Applications \nEnter 6 to View Companies \nEnter 7 to Logout and Exit");
                        int choice3 = sc.nextInt();
                        if (choice3 == 1) {
                            System.out.println("1 to View your details\n 2 to Edit your personal details\n 3 to Edit your educational details\n 4 to Reset your password\n Enter:");
                            int choice4 = sc.nextInt();
                            switch (choice4) {
                                case 1:
                                    System.out.println("Details of Students \n");
                                    student.showPersonalDetails();
                                    student.showEducationalDetails();
                                case 2:
                                    student.showPersonalDetails();
                                    System.out.println("Enter 1 to Edit your Father's Name\nEnter 2 to Edit your Mother's Name\nEnter 3 to Edit your Date of Birth\nEnter 4 to Edit your Address\nEnter 5 to Edit your City\nEnter 6 to Edit your State\nEnter 7 to Edit your Country\nEnter 8 to Edit your Pincode");
                                    int choice5 = sc.nextInt();
                                    student.editPersonalDetails(choice5);
                                    break;
                                case 3:
                                    student.showEducationalDetails();
                                    System.out.println("Enter 1 to Edit your Department\nEnter 2 to Edit your Branch\nEnter 3 to Edit your Year of Study\nEnter 4 to Edit your CGPA\nEnter 5 to Edit your Section\nEnter 6 to Edit your 10th Percentage\nEnter 7 to Edit your 12th Percentage");
                                    int choice6 = sc.nextInt();
                                    student.editEducationalDetails(choice6);
                                    break;
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
                            System.out.println("Enter the Job ID you want to add to your Job Application");
                            int jobId1 =sc.nextInt();
                            Jobs job1=jobList.getJob(jobId1);
                            student.addJob(job1);
                        }
                        else if(choice3==4){
                            System.out.println("Enter the Job ID you want to remove from your Job Application");
                            int jobId2 =sc.nextInt();
                            Jobs job2=jobList.getJob(jobId2);
                            student.removeJob(job2);
                        }
                        else  if(choice3 == 5){
//
                            student.print_jobs();
                        }
                        else if(choice3 == 6){
                            companyList.printCompanies();
                        }
                        else if(choice3 == 7){
                            System.out.println("Logged Out Successfully");
                            break;
                        }
                    } while (true);
                } else {
                    System.out.println("Invalid Credentials");
                }
            } else if (choice == 3) {
                lgn.readCredentials();
                if (lgn.checkCredentials()) {
                    lgn.printLoggedInUser();
                    do {
                        System.out.println("Enter 1 to view Users List \nEnter 2 to view Job Lists \nEnter 3 to view Company Lists \nEnter 4 to Add Job \nEnter 5 to Add Company \nEnter 6 to Remove Job \nEnter 7 to Remove Company \nEnter 8 to Logout");
                        int choice4 = sc.nextInt();
                        if (choice4 == 1) {
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
                            jobList.removeJob(jobID);
                        }
                        else if (choice4 == 7) {
                            System.out.println("Enter the Company ID");
                            String companyID = sc.next();
                            companyList.removeCompany(companyID);
                        }
                        else if (choice4 == 8) {
                            System.out.println("Logged Out Successfully");
                            break;
                        }
                    } while (true);
                }
                else
                {
                    System.out.println("Wrong Username or Password. Exiting");
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


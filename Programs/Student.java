import java.util.ArrayList;
import java.util.List;

public class Student {

    Register reg;
    PersonalDetails pd;
    EducationalDetails ed;
    User u;
   public List<Jobs> jobs ;

    public Student(PersonalDetails pd, EducationalDetails ed, Register register, User user) {
        this.pd = pd;
        this.ed = ed;
        this.reg = register;
        this.u = user;
        this.jobs = new ArrayList<>();
    }

    public void addJob(Jobs job) {
        jobs.add(job);
        System.out.println("Job added");
    }
    public void removeJob(Jobs job) {
        jobs.remove(job);
        System.out.println("Job removed");
    }
    public void print_jobs() {
        List<Jobs> jobs2 = new ArrayList<>();
        jobs2=jobs;
        System.out.println("Jobs");
        if (jobs2.isEmpty() || jobs.isEmpty()) {
            System.out.println("No jobs");
        }
       for (int i = 0; i < jobs2.size(); i++) {
            System.out.println(jobs2);
       }
    }
    public void showPersonalDetails(){
        System.out.println(pd.toString());
    }

    public void showEducationalDetails(){
        System.out.println(ed.toString());
    }

    public void showRegister(){
        System.out.println(reg.toString());
    }

    public void showUser(){
        System.out.println(u.toString());
    }

    public void editPersonalDetails(int choice){
        pd.editPersonalDetails(choice);
    }

    public void editEducationalDetails(int choice){
        ed.editEducationalDetails(choice);
    }

    public void resetPassword(){
        reg.resetPassword();
    }

}
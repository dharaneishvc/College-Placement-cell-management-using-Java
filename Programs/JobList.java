import java.util.ArrayList;
import java.util.List;

public class JobList
{

    List<Jobs> jobslist = new ArrayList<>();

    public void add(Jobs job) {
        jobslist.add(job);
    }

    public void printjobs() {
        for (Jobs job : jobslist) {
            System.out.println(job.toString());
        }
    }

    public Jobs getJob(int jobid) {
        for (Jobs job : jobslist) {
            if (job.getJobID() == jobid) {
                return job;
            }
        }
        return null;
    }


    public void printjobs(String job) {
        for (Jobs job1 : jobslist) {
            if (job1.getJobName().equals(job)) {
                System.out.println(job1.toString());
            }
        }
    }
    public List<Jobs> getJobslist() {
        return jobslist;
    }

    public void setJobslist(List<Jobs> jobslist) {
        this.jobslist = jobslist;
    }

    public void remove(Jobs job) {
        jobslist.remove(job);
    }

    public void removeJob(int jobid) {
        int a=0;
        for (int i = 0; i < jobslist.size(); i++) {
            if (jobslist.get(i).getJobID() == jobid)
            {
                jobslist.remove(i);
                System.out.println("Job Deleted successfully");
                a=1;
            }
        }
        if(a==0)
        {
            System.out.println("Job Not Found. Try again with correct JobID.");
        }
    }

    public int getJobID(int index) {
        return jobslist.get(index).getJobID();
    }

    public void updateJob(int job, String title, String description, String location, int type, float salary,int experience)
    {
        int a=0;
        for (Jobs jobs : jobslist) {
            if (jobs.getJobID() == job) {
                jobs.setJobName(title);
                jobs.setJobDescription(description);
                jobs.setJobLocation(location);
                jobs.setJobType(type);
                jobs.setSalary(salary);
                jobs.setExperience(experience);
                System.out.println("Job Details Updated successfully. Try again with correct JobID.");
                a=1;
            }
        }
        if(a==0)
        {
            System.out.println("Job Not Found");
        }
    }

    public void update(int index, Jobs job) {
        jobslist.set(index, job);
    }

    public Jobs get(int index) {
        return jobslist.get(index);
    }

    public int size() {
        return jobslist.size();
    }

    public void clear() {
        jobslist.clear();
    }

    public boolean isEmpty() {
        return jobslist.isEmpty();
    }

    public boolean contains(Jobs job) {
        return jobslist.contains(job);
    }

    public int indexOf(Jobs job) {
        return jobslist.indexOf(job);
    }

    public void sort() {
        jobslist.sort(null);
    }

    public Object[] toArray() {
        return jobslist.toArray();
    }
}

public class Jobs {
    public String JobName;
    public float Salary;
    public int JobID;
    public int Experience;
    public int JobType;
    public boolean JobStatus;
    public String JobLocation;
    public String JobDescription;

    public Jobs(String JobName, float Salary, int JobID, int Experience, int JobType, boolean JobStatus, String JobLocation, String JobDescription) {
        this.JobName = JobName;
        this.Salary = Salary;
        this.JobID = JobID;
        this.Experience = Experience;
        this.JobType = JobType;
        this.JobStatus = JobStatus;
        this.JobLocation = JobLocation;
        this.JobDescription = JobDescription;
    }
    public String getJobName() {
        return JobName;
    }
    public void setJobName(String JobName) {
        this.JobName = JobName;
    }

    public float getSalary() {
        return Salary;
    }
    public void setSalary(float Salary) {
        this.Salary = Salary;
    }

    public int getJobID() {
        return JobID;
    }
    public void setJobID(int JobID) {
        this.JobID = JobID;
    }

    public int getExperience() {
        return Experience;
    }
    public void setExperience(int Experience) {
        this.Experience = Experience;
    }

    public int getJobType() {
        return JobType;
    }
    public void setJobType(int JobType) {
        this.JobType = JobType;
    }

    public boolean getJobStatus() {
        return JobStatus;
    }
    public void setJobStatus(boolean JobStatus) {
        this.JobStatus = JobStatus;
    }

    public String getJobLocation() {
        return JobLocation;
    }
    public void setJobLocation(String JobLocation) {
        this.JobLocation = JobLocation;
    }

    public String getJobDescription() {
        return JobDescription;
    }
    public void setJobDescription(String JobDescription) {
        this.JobDescription = JobDescription;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "JobName='" + JobName + '\'' +
                ", Salary=" + Salary +
                ", JobID=" + JobID +
                ", Experience=" + Experience +
                ", JobType=" + JobType +
                ", JobStatus=" + JobStatus +
                ", JobLocation='" + JobLocation + '\'' +
                ", JobDescription='" + JobDescription + '\'' +
                '}';
    }

}

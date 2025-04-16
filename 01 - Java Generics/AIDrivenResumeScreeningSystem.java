import java.util.*;
abstract class JobRole {
    String jobTitle;
    String requiredSkills;

    public JobRole(String jobTitle, String requiredSkills) {
        this.jobTitle = jobTitle;
        this.requiredSkills = requiredSkills;
    }

    public abstract void displayJobDetails();
}
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer", "Java, Python, Algorithms");
    }

    @Override
    public void displayJobDetails() {
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Required Skills: " + requiredSkills);
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist", "Python, Machine Learning, Data Analysis");
    }

    @Override
    public void displayJobDetails() {
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Required Skills: " + requiredSkills);
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager", "Product Strategy, Agile, Communication");
    }

    @Override
    public void displayJobDetails() {
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Required Skills: " + requiredSkills);
    }
}
class Resume<T extends JobRole> {
    T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void processResume() {
        System.out.println("Processing resume for: " + jobRole.jobTitle);
        jobRole.displayJobDetails();
    }
}
class ResumeScreeningSystem {
    public static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            System.out.println("\nScreening Resume for: " + resume.jobTitle);
            resume.displayJobDetails();
        }
    }

    public static void main(String[] args) {
        SoftwareEngineer softwareEngineer = new SoftwareEngineer();
        DataScientist dataScientist = new DataScientist();
        ProductManager productManager = new ProductManager();
        Resume<SoftwareEngineer> resume1 = new Resume<>(softwareEngineer);
        Resume<DataScientist> resume2 = new Resume<>(dataScientist);
        Resume<ProductManager> resume3 = new Resume<>(productManager);
        resume1.processResume();
        resume2.processResume();
        resume3.processResume();
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(softwareEngineer);
        jobRoles.add(dataScientist);
        jobRoles.add(productManager);
        ResumeScreeningSystem.processResumes(jobRoles);
    }
}
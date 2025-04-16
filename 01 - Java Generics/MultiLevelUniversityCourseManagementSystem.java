import java.util.List;
import java.util.ArrayList;

abstract class CourseType {
    private String evaluationType;

    public CourseType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    public String getEvaluationType() {
        return evaluationType;
    }

    @Override
    public String toString() {
        return evaluationType;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "Course Name: " + courseName + ", Evaluation Type: " + courseType.getEvaluationType();
    }
}

public class MultiLevelUniversityCourseManagementSystem {

    public static void printCourseDetails(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> examCourse = new Course<>("Math 101", new ExamCourse());
        Course<AssignmentCourse> assignmentCourse = new Course<>("Programming 101", new AssignmentCourse());
        Course<ResearchCourse> researchCourse = new Course<>("AI Research", new ResearchCourse());

        System.out.println("Individual Course Details:");
        System.out.println(examCourse);
        System.out.println(assignmentCourse);
        System.out.println(researchCourse);

        System.out.println("\nCourse List Details:");
        List<CourseType> courseList = new ArrayList<>();
        courseList.add(examCourse.getCourseType());
        courseList.add(assignmentCourse.getCourseType());
        courseList.add(researchCourse.getCourseType());

        printCourseDetails(courseList);
    }
}
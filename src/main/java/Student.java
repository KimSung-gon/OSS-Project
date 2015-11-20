import java.util.ArrayList;

public class Student {

    ArrayList<String> takingClass;
    int studentID;
    int age;
    String name;
    String major;

    public Student(int studentID, int age, String name, String major, ArrayList<String> takingClass) {
        this.takingClass = takingClass;
        this.studentID = studentID;
        this.age = age;
        this.name = name;
        this.major = major;
    }

    public Student(Student student){
        student.takingClass = takingClass;
        student.studentID = studentID;
        student.age = age;
        student.name = name;
        student.major = major;
    }
}

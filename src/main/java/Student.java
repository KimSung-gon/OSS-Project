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

    public Student(){}

    public ArrayList<String> getTakingClass() {
        return takingClass;
    }

    public void setTakingClass(ArrayList<String> takingClass) {
        this.takingClass = takingClass;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}

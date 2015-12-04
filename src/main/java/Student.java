import java.util.ArrayList;

public class Student {

    int studentID;
    int age;
    String name;
    String major;
    ArrayList<String> takingClass;

    public Student(int studentID, int age, String name, String major, ArrayList<String> takingClass) {
        this.takingClass = takingClass;
        this.studentID = studentID;
        this.age = age;
        this.name = name;
        this.major = major;
    }

    public Student(Student student) {
        student.takingClass = takingClass;
        student.studentID = studentID;
        student.age = age;
        student.name = name;
        student.major = major;
    }

    public void showTakingClass() {
        System.out.printf("수강과목\n");
        for (int i = 0; i < this.takingClass.size(); i++) {
            System.out.printf("%s\n", this.takingClass.get(i));
        }


    }
}

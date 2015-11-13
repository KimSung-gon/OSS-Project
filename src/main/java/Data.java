import java.util.ArrayList;

public class Data {

    Data ( int studentID, String name, String major ) {
        this.studentID = studentID;
        this.name = name;
        this.major = major;
    }

    Data ( int studentID, String name, String major, int age ) {

        this(studentID, name, major );
        this.age = age;
    }


    int studentID;
    String name;
    int age;
    String major;
    ArrayList<String> takingClass;


}


// TODO 학생 정보 저장
// TODO 학생 정보 수정
// TODO 학생 정보 삭제

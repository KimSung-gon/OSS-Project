import java.util.ArrayList;
import java.util.Scanner;

public class Data {

    private static Data datIinstance;
    private Data(){}

    public static Data getInstance(){
        if(datIinstance == null)
            datIinstance = new Data();

        return datIinstance;
    }

    public void saveData(){

        Scanner sc = new Scanner( System.in );

        int studentID;
        int age;
        String name;
        String major;

        System.out.print("이름 : ");
        name = sc.next();

        System.out.print("학번 : ");
        studentID = sc.nextInt();

        System.out.print("나이 : ");
        age = sc.nextInt();

        System.out.print("전공 : ");
        major = sc.next();

//        TODO 수강중인 과목 함수 호출해서 저장하기
//        ArrayList<String> takeclass = new ArrayList<String>();
//        takeclass.add("Math");
//        takeclass.add("English");
//        StudentList.getInstance().slist.add(new Student(studentID, age, name, major, takeclass));
    }

    public void modifyData(){

       // TODO 학번 입력받아서 학생 정보 받아온 뒤에 원하는 정보 수정

    }

    public void removeData(){
       int idx = 0;

//        TODO 지울 데이터 계산해서 매개변수로 전달
        StudentList.getInstance().slist.remove( idx );

    }

}


// TODO 학생 정보 저장
// TODO 학생 정보 수정
// TODO 학생 정보 삭제

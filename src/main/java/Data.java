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

    // txt 파일에 있는 데이터를 읽어 slist에 저장시켜주는 메소드
    public void readData(){

    }

    // txt 파일에 slist의 데이터를 써주는 메소드
    public void saveToTxt(){

    }

    // slist에 학생 정보를 저장하는 매소드
    public void saveData(){

        Scanner sc = new Scanner( System.in );

        ArrayList<String> takeclass = new ArrayList<String>();
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

        System.out.println("수강중인 과목 : ");
        while(true){
            System.out.println("과목 입력을 멈추시려면 1을 입력해 주세요.");
            String lecture = sc.next();
            if(lecture == "1")
                break;
            else
                takeclass.add(lecture);
        }

        StudentList.getInstance().slist.add(new Student(studentID, age, name, major, takeclass));
    }

    public void modifyData(){

       // TODO 학번 입력받아서 학생 정보 받아온 뒤에 원하는 정보 수정

    }

    public void removeData(){

        Scanner sc = new Scanner( System.in );
        int studentId;
        int i;

        System.out.print("지우고자 하는 학생의 학번을 입력해 주세요 : ");

        studentId = sc.nextInt();


        for(i = 0 ; i < StudentList.getInstance().slist.size() ; i++ ){
            if(StudentList.getInstance().slist.get(i).studentID == studentId)
                StudentList.getInstance().slist.remove( studentId );

        }

        if(i == StudentList.getInstance().slist.size()+1)
            System.out.println("삭제할 학생이 없습니다.");

    }

}


// TODO 학생 정보 저장
// TODO 학생 정보 수정
// TODO 학생 정보 삭제

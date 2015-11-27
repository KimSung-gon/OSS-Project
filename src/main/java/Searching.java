import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Searching {

    public static void searchDataOfStudent(){                   // 학번을 통한 정보 검색
        System.out.println("찾고자 하는 학생의 학번을 입력해 주세요 : ");
        int studentId =Integer.parseInt(inputString());
        for(int i=0; i<StudentList.getInstance().slist.size(); i++) {
            if (StudentList.getInstance().slist.get(i).studentID == studentId) {
                showdata(StudentList.getInstance().slist.get(i));
                returnMenu();
                break;
            }
            if (i == StudentList.getInstance().slist.size()) {
                System.out.println("조회되는 학번이 없습니다.");
                returnMenu();
                break;
            }
        }
    }

    public static void showAllData(){                   // 전체 학생수, 모든 학생데이터 출력

        for(int i=0; i<StudentList.getInstance().slist.size(); i++)
            showdata(StudentList.getInstance().slist.get(i));

        System.out.println("\n총 학생 수 : " + StudentList.getInstance().slist.size());
        returnMenu();
    }

    public static void showdata(Student student){
        System.out.println("\n학번 : " + student.studentID);
        System.out.println("나이 : " + student.age);
        System.out.println("이름 : " + student.name);
        System.out.println("전공 : " + student.major);

        System.out.println("\n수강중인 과목");
        for(int j=0; j<student.takingClass.size(); j++)
            System.out.println("[" + j + "]" + student.takingClass.get(j));
    }

    public static void searchDataOfSubject(){                   // 과목을 통한 정보 검색
        System.out.print("찾고자 하는 과목명을 입력해 주세요 : ");
        String subject = inputString();
        for(int i=0; i<StudentList.getInstance().slist.size(); i++)
            for(int j=0; j<StudentList.getInstance().slist.get(i).takingClass.size(); j++)
                if(StudentList.getInstance().slist.get(i).takingClass.get(j).compareTo(subject) == 0)
                    showStudentIdAndName(StudentList.getInstance().slist.get(i));
        returnMenu();
    }

    public static void searchDataOfMajor(){                 // 전공을 통한 정보 검색
        System.out.print("찾고자 하는 전공명을 입력해 주세요 : ");
        String major = inputString();
        for(int i=0; i<StudentList.getInstance().slist.size(); i++)
            if(StudentList.getInstance().slist.get(i).major.compareTo(major) == 0)
                showStudentIdAndName(StudentList.getInstance().slist.get(i));
        returnMenu();
    }

    public static void searchDataOfYear(){                  // 학번을 통한 정보 검색
        System.out.print("찾고자 하는 입학년도를 네자리로 입력해 주세요 : ");
        int year = Integer.parseInt(inputString());
        for(int i=0; i<StudentList.getInstance().slist.size(); i++)
            if(StudentList.getInstance().slist.get(i).studentID/10000 == year)
                showStudentIdAndName(StudentList.getInstance().slist.get(i));
        returnMenu();
    }

    public static void showStudentIdAndName(Student student){
        System.out.print("학번 : " + student.studentID);
        System.out.println("    이름 : " + student.name);
    }

    public static String inputString(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public static void returnMenu(){
        System.out.print("\n메뉴로 돌아가려면 아무 키나 입력하세요 : ");
        inputString();
    }

}
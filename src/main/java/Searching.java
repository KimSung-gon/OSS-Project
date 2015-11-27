import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Searching {

    public static void searchDataOfStudent(){                   // 학번을 통한 정보 검색
        int studentId =Integer.parseInt(inputString());
        for(int i=0; i<StudentList.getInstance().slist.size(); i++)
            if(StudentList.getInstance().slist.get(i).studentID == studentId)
                showdata(StudentList.getInstance().slist.get(i));
            else{
                System.out.println("조회되는 학번이 없습니다.");
                System.out.println("1.다시입력  2.나가기");
                int decide = Integer.parseInt(inputString());
                while((decide == 1) || (decide == 2)) {
                    if (decide == 1)
                        Searching.searchDataOfStudent();
                    if (decide == 2)
                        Manager.showMainMenu();
                }
            }
    }

    public static void showAllData(){                   // 전체 학생수, 모든 학생데이터 출력

        for(int i=0; i<StudentList.getInstance().slist.size(); i++)
            showdata(StudentList.getInstance().slist.get(i));

        System.out.println("\n총 학생 수 : " + StudentList.getInstance().slist.size());
        System.out.println("\n메뉴로 돌아가려면 아무 키나 입력하세요.");
        inputString();

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
        String subject = inputString();
        for(int i=0; i<StudentList.getInstance().slist.size(); i++)
            for(int j=0; j<StudentList.getInstance().slist.get(i).takingClass.size(); j++)
                if(StudentList.getInstance().slist.get(i).takingClass.get(j) == subject)
                    showStudentIdAndName(StudentList.getInstance().slist.get(i));
    }

    public static void searchDataOfMajor(){                 // 전공을 통한 정보 검색
        String major = inputString();
        for(int i=0; i<StudentList.getInstance().slist.size(); i++)
            if(StudentList.getInstance().slist.get(i).major == major)
                showStudentIdAndName(StudentList.getInstance().slist.get(i));
    }

    public static void searchDataOfYear(){                  // 학번을 통한 정보 검색
        int year = Integer.parseInt(inputString());
        for(int i=0; i<StudentList.getInstance().slist.size(); i++)
            if(StudentList.getInstance().slist.get(i).studentID/1000 == year)
                showStudentIdAndName(StudentList.getInstance().slist.get(i));
    }

    public static void showStudentIdAndName(Student student){
        System.out.print("학번 : " + student.studentID);
        System.out.println("    이름 : " + student.name);
    }

    public static String inputString(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

}
// TODO 학번을 통한 개인정보 상세 검색
// TODO 저장된 학생 전체 정보에 대한 개요, 통계 출력
// TODO 과목명에 따른 학생 검색
// TODO 학과에 따른 학생 검색
// TODO 입학년도에 따른 학생 검색

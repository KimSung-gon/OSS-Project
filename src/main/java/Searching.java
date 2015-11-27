import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Searching {

    public static void searchDataOfStudent(){                   // 학번을 통한 정보 검색
        Scanner sc = new Scanner(System.in);
        int studentId = sc.nextInt();
        for(int i=0; i<StudentList.getInstance().slist.size(); i++)
            if(StudentList.getInstance().slist.get(i).studentID == studentId){
                System.out.println("학번 : " + StudentList.getInstance().slist.get(i).studentID);
                System.out.println("나이 : " + StudentList.getInstance().slist.get(i).age);
                System.out.println("이름 : " + StudentList.getInstance().slist.get(i).name);
                System.out.println("전공 : " + StudentList.getInstance().slist.get(i).major);
                for(int j=0; j<StudentList.getInstance().slist.get(i).takingClass.size(); j++)
                    System.out.println("수강과목 : " + StudentList.getInstance().slist.get(i).takingClass.get(j));
            }
            else{
                System.out.println("조회되는 학번이 없습니다.");
                System.out.println("1.다시입력  2.나가기");
                int decide = sc.nextInt();
                while((decide == 1) || (decide == 2)) {
                    if (decide == 1)
                        Searching.searchDataOfStudent();
                    if (decide == 2)
                        Manager.showMainMenu();
                }
            }
    }

    public static void showAllData(){                   // 전체 학생수, 모든 학생데이터 출력
        Scanner sc = new Scanner(System.in );

        for(int i=0; i<StudentList.getInstance().slist.size(); i++){
            System.out.println("총 학생 수 : " + StudentList.getInstance().slist.size());
            System.out.println();
            System.out.println("학번 : " + StudentList.getInstance().slist.get(i).studentID);
            System.out.println("나이 : " + StudentList.getInstance().slist.get(i).age);
            System.out.println("이름 : " + StudentList.getInstance().slist.get(i).name);
            System.out.println("전공 : " + StudentList.getInstance().slist.get(i).major);

            System.out.println("\n수강중인 과목");
            for(int j=0; j<StudentList.getInstance().slist.get(i).takingClass.size(); j++)
                System.out.println("[" + j+1 + "]" + StudentList.getInstance().slist.get(i).takingClass.get(j));
        }

        System.out.println("\n메뉴로 돌아가려면 아무 키나 입력하세요.");
        sc.next();

    }

    public static void searchDataOfSubject(){                   // 과목을 통한 정보 검색

        Scanner sc = new Scanner(System.in);
        String subject = sc.next();
        for(int i=0; i<StudentList.getInstance().slist.size(); i++)
            for(int j=0; j<StudentList.getInstance().slist.get(i).takingClass.size(); j++)
                if(StudentList.getInstance().slist.get(i).takingClass.get(j) == subject){
                    System.out.print("학번 : " + StudentList.getInstance().slist.get(i).studentID);
                    System.out.println("    이름 : " + StudentList.getInstance().slist.get(i).name);
                }
    }

    public static void searchDataOfMajor(){                 // 전공을 통한 정보 검색

        Scanner sc = new Scanner(System.in);
        String major = sc.next();
        for(int i=0; i<StudentList.getInstance().slist.size(); i++)
            if(StudentList.getInstance().slist.get(i).major == major){
                System.out.print("학번 : " + StudentList.getInstance().slist.get(i).studentID);
                System.out.println("    이름 : " + StudentList.getInstance().slist.get(i).name);
            }
    }

    public static void searchDataOfYear(){                  // 학번을 통한 정보 검색

        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        for(int i=0; i<StudentList.getInstance().slist.size(); i++)
            if(StudentList.getInstance().slist.get(i).studentID/1000 == year){
                System.out.print("학번 : " + StudentList.getInstance().slist.get(i).studentID);
                System.out.println("    이름 : " + StudentList.getInstance().slist.get(i).name);
            }
    }
}
// TODO 학번을 통한 개인정보 상세 검색
// TODO 저장된 학생 전체 정보에 대한 개요, 통계 출력
// TODO 과목명에 따른 학생 검색
// TODO 학과에 따른 학생 검색
// TODO 입학년도에 따른 학생 검색

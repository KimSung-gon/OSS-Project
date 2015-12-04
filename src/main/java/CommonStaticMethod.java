import java.util.Scanner;

public class CommonStaticMethod {

    protected final static int askStudentID() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }                            // 학번을 입력받아 리턴

    protected final static int searchStudentIdxNumberByStudentID( StudentList sList) {
        // 못찾을시 -1 반환
        int studentId = askStudentID();
        for (int i = 0; i < sList.getInstance().slist.size(); i++) {
            if (sList.getInstance().slist.get(i).studentID == studentId) {
                return i;
            }
        }
        return -1;
    }       // 학번을 입력받아 인덱스를 리턴

    protected final static void showStudentData(Student s) {
        System.out.printf("학번 : %d\n", showStudentID( s ));
        System.out.printf("이름 : %s\n", showStudentName( s ));
        System.out.printf("나이 : %d\n", showStudentAge( s ));
        System.out.printf("전공 : %s\n", showStudentMajor( s ));
        s.showTakingClass();
    }             // 학생 개인정보 출력


    protected final static int showStudentID ( Student s ) {
        return s.studentID;
    }

    protected final static String showStudentName ( Student s ) {
        return s.name;
    }

    protected final static int showStudentAge ( Student s ){
        return s.age;
    }

    protected  final static String showStudentMajor ( Student s ) {
        return s.major;
    }




    protected final static String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }                            // 문자열을 입력받아 리턴

    protected final static int inputInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }                                 // 정수형을 입력받아 리턴

    protected final static void returnFalseMenu() {
        System.out.println("잘못된 입력입니다.");
    }

    protected final static void returnMenu(){
        System.out.print("메뉴로 돌아가려면 아무 키나 입력하세요 : ");
        inputString();
    }                               // 메뉴로 돌아가기

    protected final static void showStudentIdAndName(Student student){
        System.out.print("학번 : " + student.studentID);
        System.out.println("\t이름 : " + student.name);
    }       // 학생이름과 학번 출력

}

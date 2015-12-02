import java.util.Scanner;

public class CommonStaitcMethod {

    protected final static int askStudentID() {
        Scanner sc = new Scanner( System.in );
        return sc.nextInt();
    }

    protected final static int searchStudentIdxNumberByStudentID() {
        // 못찾을시 -1 반환
        int studentId = askStudentID();
        for (int i = 0; i < StudentList.getInstance().slist.size(); i++) {
            if (StudentList.getInstance().slist.get(i).studentID == studentId) {
                return i;
            }
        }
        return -1;
    }

    protected final static void showStudentData( Student s ) {
        System.out.printf("학번 : %d\n", s.studentID );
        System.out.printf("이름 : %s\n", s.name );
        System.out.printf("나이 : %d\n", s.age );
        System.out.printf("전공 : %s\n", s.major );
        s.showTakingClass();
    }

    protected final static String inputString(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    protected final static int inputInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    protected final static void returnMenu(){
        System.out.print("메뉴로 돌아가려면 아무 키나 입력하세요 : ");
        inputString();
    }

    protected final static void showStudentIdAndName(Student student){
        System.out.print("학번 : " + student.studentID);
        System.out.println("\t이름 : " + student.name);
    }

}

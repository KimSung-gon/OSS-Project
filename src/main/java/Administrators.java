import java.util.ArrayList;
import java.util.Scanner;

public class Administrators {

    private static ArrayList<Administrator> alist;
    private final String adminID[] = {"fharenheit", "20091130", "20103308", "20113300"};          // 관리자들 학번
    private final String password[] = {"rlaqudrhs", "dlaehdgns", "rlatjdrhs", "dbsaudtlr"};      // 관리자들 비밀번호(이름)

    private static int count = 3;                                                   // 비밀번호 입력 카운트
    private static boolean checkReturn;                                             // 메뉴로 가기 또는 종료
    private static String tmpContinue = "1";                                        // 아이디 입력 반복변수

    Administrators() {
        alist = new ArrayList<Administrator>();
        for (int i = 0; i < adminID.length; i++)
            alist.add(new Administrator(adminID[i], password[i]));
    }                                                   // alist에 admnID,password 추가

    public static boolean loginStart() {

        Administrators admins = new Administrators();

        while (tmpContinue.equals("1")) {

            String adminID = admins.fetchID();

            boolean tmpIDexist = admins.IDexist(adminID);
            int tmpIndexNumberOfID = admins.IndexNumberOfID(adminID);

            admins.loginIDLoop(tmpIDexist, tmpIndexNumberOfID);
        }
        return checkReturn;
    }                                       // 로그인

    public String loginIDLoop(boolean tmpIDexist, int tmpIndexNumberOfID) {

        if (tmpIDexist == true) {

            while (count > 0) {

                String adminPassword = fetchPassword();
                boolean tmpAdminPassword = checkPassword(tmpIndexNumberOfID, adminPassword);
                loginPasswordLoop(tmpAdminPassword);
            }

        } else {
            printWrongID();
            String tmpStr = inputString();
            if(tmpContinue.equals(tmpStr))
                tmpContinue = tmpStr;
            else
                tmpContinue = "0";
            for (int i = 0; i < 5; i++)
                System.out.println();
        }
        return tmpContinue;
    }        //  로그인아이디 매뉴얼

    public boolean loginPasswordLoop(boolean tmpAdminPassword) {

        if (tmpAdminPassword == true) {
            System.out.println("로그인 되었습니다");
            tmpContinue = "0";
            checkReturn = true;
            count = 0;
        } else {
            printWrongPassword();
            if (count == 0)
                tmpContinue = "0";
            checkReturn = false;
        }
        return checkReturn;
    }                  // 로그인비밀번호 매뉴얼

    public boolean IDexist(String studentNumber) {

        for (int i = 0; i < alist.size(); i++)
            if (studentNumber.equals(alist.get(i).adminID))
                return true;
        return false;
    }                                // 관리자확인

    public int IndexNumberOfID(String studentNumber) {

        int tmpReturnValue = -1;
        for (int i = 0; i < alist.size(); i++)
            if (studentNumber.equals(alist.get(i).adminID)) {
                tmpReturnValue++;
                tmpReturnValue += i;
            }
        return tmpReturnValue;
    }                             // 관리자학번 인덱스값 리턴

    public boolean checkPassword(int IndexNumberOfID, String password) {

        if (this.password[IndexNumberOfID].equals(password))
            return true;
        else
            return false;
    }         // 비밀번호 확인

    public String fetchID() {
        System.out.print("관리자 학번을 입력해주세요 : ");
        return inputString();
    }                                                      // 관리자학번 받아오기

    public String fetchPassword() {
        System.out.print("비밀번호를 입력해주세요 : ");
        return inputString();
    }                                                // 비밀번호 받아오기

    public void printWrongID() {
        System.out.println();
        System.out.println("관리자 학번이 아닙니다");
        System.out.println("1.다시입력");
        System.out.println("종료하려면 아무키나 누르세요");
    }                                   // 아이디가 틀릴경우 출력문

    public void printWrongPassword() {
        count--;
        System.out.println();
        System.out.println("비밀번호가 틀렸습니다");
        System.out.println("3회 이상 틀리면 자동종료 됩니다. 남은횟수 : " + count);
    }                             // 비밀번호가 틀릴경우 출력문

    public String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }                                   // String형 입력받기

    public int inputStringNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }                               // Int형 입력받기
}
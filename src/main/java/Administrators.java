import java.util.ArrayList;

public class Administrators extends CommonStaticMethod {

    private static ArrayList<Administrator> alist;
    private final String adminID[] = {"20091130", "20103308", "20113300"};          // 관리자들 학번
    private final String password[] = {"dlaehdgns", "rlatjdrhs", "dbsaudtlr"};      // 관리자들 비밀번호(이름)

    private boolean checkReturn;            // 관리자 프로그램 실행여부 변수
    private boolean IDexist = false;        // ID의 존재여부 변수. default 값으로 false를 넣음
    private boolean loop = true;              // ID가 맞을때까지 반복여부의 변수

    private Administrators() {
        alist = new ArrayList<>();
        for (int i = 0; i < adminID.length; i++)
            alist.add(new Administrator(adminID[i], password[i]));
    }

    public static final boolean checkAdmin() {

        Administrators admins = new Administrators();

        while (admins.loop) {

            admins.loginID();
            admins.continueLogin();
        }
        return admins.checkReturn;
    }   // 관리자 인증메서드

    private void loginID() {

        System.out.print("관리자 학번을 입력해주세요 : ");
        String tempID = inputStringNumber();

        for (int i = 0; i < alist.size(); i++) {
            if (tempID.equals(alist.get(i).adminID)) {
                IDexist = true;
                loop = false;
                int count = 3;
                loginPassword(i);
            }
        }
    }                   // 관리자 학번을 입력

    private void loginPassword(int i) {
        int count = 3;
        while (count > 0) {
            System.out.print("비밀번호를 입력해주세요 : ");
            String tempPassword = inputString();
            if (tempPassword.equals(alist.get(i).adminPassword)) {
                checkReturn = true;
                break;
            } else {
                System.out.println("잘못된 비밀번호 입니다.");
                count--;
                System.out.println("남은 입력횟수 : " + count);
                checkReturn = false;
            }
        }
    }        // 관리자 비밀번호로 인증

    private void continueLogin() {

        if (IDexist == false) {
            checkReturn = false;
            System.out.println("관리자학번이 아닙니다");
            System.out.println("1.다시입력");
            System.out.println("종료하려면 아무거나 누르십시오");
            String tempContinue = inputString();
            if (tempContinue.equals("1"))
                loop = true;
            else
                loop = false;
        }
    }              // 관리자 ID가 맞지 않을때 다시입력받는 메서드
}

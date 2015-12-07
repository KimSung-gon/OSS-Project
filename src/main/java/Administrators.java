import java.util.ArrayList;
import java.util.Scanner;

public class Administrators {

    private static ArrayList<Administrator> alist;
    private final String adminID[] = {"20091130", "20103308", "20113300"};          // 관리자들 학번
    private final String password[] = {"dlaehdgns", "rlatjdrhs", "dbsaudtlr"};      // 관리자들 비밀번호(이름)

    private static int count = 3;
    private static boolean checkReturn;
    private static String tmpContinue = "1";

    private Administrators() {
        alist = new ArrayList<>();
        for (int i = 0; i < adminID.length; i++)
            alist.add(new Administrator(adminID[i], password[i]));
    }

    public static boolean loginStart() {

        Administrators admins = new Administrators();

        while (tmpContinue.equals("1")) {

            String adminID = admins.fetchID();

            boolean tmpIDexist = admins.IDexist(adminID);
            int tmpIndexNumberOfID = admins.IndexNumberOfID(adminID);

            admins.succeessLoginID(tmpIDexist, tmpIndexNumberOfID);
        }
        return checkReturn;
    }

    public void succeessLoginID(boolean tmpIDexist, int tmpIndexNumberOfID) {

        if (tmpIDexist == true) {

            while( count > 0 ) {

                String adminPassword = fetchPassword();
                boolean tmpAdminPassword = checkPassword(tmpIndexNumberOfID, adminPassword);
                successLoginPassword(tmpAdminPassword);
            }

        } else {
            printWrongID();
            tmpContinue = inputString();
            for(int i=0; i<5; i++)
                System.out.println();
        }
    }
    public boolean successLoginPassword(boolean tmpAdminPassword){

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
    }
    public boolean IDexist(String studentNumber) {

        for (int i = 0; i < alist.size(); i++)
            if (studentNumber.equals(alist.get(i).adminID))
                return true;
        return false;
    }
    public int IndexNumberOfID(String studentNumber) {

        int tmpReturnValue = -1;
        for (int i = 0; i < alist.size(); i++)
            if (studentNumber.equals(alist.get(i).adminID)) {
                tmpReturnValue++;
                tmpReturnValue += i;
            }
        return tmpReturnValue;
    }
    public boolean checkPassword(int IndexNumberOfID, String password) {

        if (this.password[IndexNumberOfID].equals(password))
            return true;
        else
            return false;
    }

    public String fetchID() {
        System.out.print("관리자 학번을 입력해주세요 : ");
        return inputString();
    }
    public String fetchPassword() {
        System.out.print("비밀번호를 입력해주세요 : ");
        return inputString();
    }

    public void printWrongID() {
        System.out.println();
        System.out.println("관리자 학번이 아닙니다");
        System.out.println("1.다시입력");
        System.out.println("종료하려면 아무키나 누르세요");
    }
    public void printWrongPassword() {
        count--;
        System.out.println();
        System.out.println("비밀번호가 틀렸습니다");
        System.out.println("3회 이상 틀리면 자동종료 됩니다. 남은횟수 : " + count);
    }

    public String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
    public int inputStringNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
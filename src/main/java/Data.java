import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Data extends CommonStaticMethod {

    private static Data datIinstance;

    private Data() {
    }

    public static Data getInstance() {
        if (datIinstance == null)
            datIinstance = new Data();

        return datIinstance;
    }

    public static void loadDataFromFile() throws IOException {

        File f = new File("studentList.txt");
        if (f.canRead()) {
            Reader read = new FileReader("studentList.txt");
            BufferedReader bReader = new BufferedReader(read);
            String tmp = bReader.readLine();

            while (tmp != null && tmp.compareTo("#") == 0) {
                if (tmp.compareTo("#") == 0) {
                    String studentID = bReader.readLine();

                    if (studentID == null)
                        break;

                    String age = bReader.readLine();
                    String name = bReader.readLine();
                    String major = bReader.readLine();
                    ArrayList<String> takingClass = new ArrayList<String>();

                    String temp = bReader.readLine();
                    while (temp != null && temp.compareTo("#") != 0) {
                        takingClass.add(temp);
                        temp = bReader.readLine();
                    }
                    Student newStudent = new Student(Integer.parseInt(studentID), Integer.parseInt(age), name, major, takingClass);
                    StudentList.getInstance().slist.add(newStudent);
                } else
                    break;
            }
            bReader.close();
            read.close();
        } else
            f.createNewFile();
    }           // 텍스트파일에 정보를 학생리스트로 불러옴

    public static void saveDataToFile() throws IOException {
        Writer write = new FileWriter("studentList.txt");
        BufferedWriter bWriter = new BufferedWriter(write);

        if (StudentList.getInstance().slist != null) {

            for (int i = 0; i < StudentList.getInstance().slist.size(); i++) {

                bWriter.append("#\n");
                bWriter.append(String.valueOf(StudentList.getInstance().slist.get(i).studentID) + "\n");
                bWriter.append(String.valueOf(StudentList.getInstance().slist.get(i).age) + "\n");
                bWriter.append(StudentList.getInstance().slist.get(i).name + "\n");
                bWriter.append(StudentList.getInstance().slist.get(i).major + "\n");

                for (int j = 0; j < StudentList.getInstance().slist.get(i).takingClass.size(); j++) {
                    bWriter.append(StudentList.getInstance().slist.get(i).takingClass.get(j) + "\n");
                }
                bWriter.flush();
            }
        }
        bWriter.close();
        write.close();
    }             // 학생리스트를 텍스트파일에 저장

    public static void saveStudentData() {

        ArrayList<String> takeclass = new ArrayList<String>();
        int studentID;
        int age;
        String name;
        String major;

        System.out.println("========== 1. 데이터 추가 ===========");
        System.out.print("이름 : ");
        name = inputString();

        System.out.print("학번 : ");
        studentID = inputInt();

        System.out.print("나이 : ");
        age = inputInt();

        System.out.print("전공 : ");
        major = inputString();

        System.out.println("과목 입력을 멈추시려면 \"stop\"을 입력해 주세요.");
        int i = 1;

        while (true) {
            System.out.printf("수강중인 과목 %d : ", i);
            String lecture = inputString();
            if (lecture.compareTo("stop") == 0) {
                break;
            } else {
                takeclass.add(lecture);
                i++;
            }
        }
        StudentList.getInstance().slist.add(new Student(studentID, age, name, major, takeclass));
        System.out.printf("현재 수강중인 과목(%d개) 저장되었습니다", i - 1);
    }                                // 학생리스트에 학생정보 저장

    public static void modifyStudentData() {

        Scanner sc = new Scanner(System.in);
        int changeDataNumber;
        System.out.print("변경 할 학번을 입력하세요 : ");
        int idx = searchStudentIdxNumberByStudentID(StudentList.getInstance());

        if (idx == -1) {
            System.out.printf("입력하신 학번은 존재하지 않습니다");
            return;
        }

        while (true) {
            showWayToModify();
            changeDataNumber = sc.nextInt();

            switch (changeDataNumber) {
                case 1:
                    modifyStudentAge(idx);
                    break;
                case 2:
                    modifyStudentName(idx);
                    break;
                case 3:
                    modifyStudentMajor(idx);
                    break;
                case 4:
                    modifyTakingClass(idx);
                    break;
                default:
                    return;
            }
        }
    }                              // 학생리스트에 학생정보 변경

    public static int removeStudentData(int idx) {

        System.out.println("빠졋다2");

        if (idx == -1) {
            System.out.println("삭제할 학생이 없습니다.");
            returnMenu();
            return -1;
        }
        else {
            showStudentData(StudentList.getInstance().slist.get(idx));
            return 1;
        }
    }

    public static void removeStudentDataConfirm(int confirm, boolean choice){

        if ( choice ) {
            StudentList.getInstance().slist.remove(confirm);
            System.out.println("삭제되었습니다.");
        } else {
            System.out.println("삭제를 취소합니다.");
        }
        returnMenu();
    }                              // 학생리스트에 학생정보 삭제


    /*****************
     * 아래부터는 정보은닉된 메소드입니다.
     *****************/

    private static void showWayToModify() {
        System.out.println("====================");
        System.out.println("데이터 수정");
        System.out.println("1.나이");
        System.out.println("2.이름");
        System.out.println("3.전공");
        System.out.println("4.수강중인 수업");
        System.out.println("5.나가기");
        System.out.println("====================");
        System.out.print("수정할 데이터 번호를 입력하세요 : ");
    }

    static boolean choiceSaveDataOrNot( String s ) {

        if ( s.compareTo( "y" ) == 0 ||
                s.compareTo( "Y" ) == 0 ||
                s.compareTo( "yes" ) == 0 ||
                s.compareTo( "Yes" ) == 0 ||
                s.compareTo( "YES" ) == 0 )
            return true;
        else
            return false;
    }

    private static void modifyStudentAge(int idx) {
        Scanner sc = new Scanner(System.in);
        System.out.println("현재 나이 : " + StudentList.getInstance().slist.get(idx).age);
        System.out.print("변경할 나이를 입력하세요 : ");
        int ageToChange = sc.nextInt();
        StudentList.getInstance().slist.get(idx).age = ageToChange;
    }

    private static void modifyStudentName(int idx) {
        Scanner sc = new Scanner(System.in);
        System.out.println("현재 이름 : " + StudentList.getInstance().slist.get(idx).name);
        System.out.print("변경할 이름을 입력하세요 : ");
        String nameToChange = sc.next();
        StudentList.getInstance().slist.get(idx).name = nameToChange;
    }

    private static void modifyStudentMajor(int idx) {
        Scanner sc = new Scanner(System.in);
        System.out.println("현재 전공 : " + StudentList.getInstance().slist.get(idx).major);
        System.out.print("변경할 전공을 입력하세요 : ");
        String majorToChange = sc.next();
        StudentList.getInstance().slist.get(idx).major = majorToChange;
    }

    private static void modifyTakingClass(int idx) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("현재 수강중인 과목 : ");
            for (int j = 0; j < StudentList.getInstance().slist.get(idx).takingClass.size(); j++)
                System.out.println(StudentList.getInstance().slist.get(idx).takingClass.get(j));
            System.out.println("1.추가    2.삭제    3.나가기");
            System.out.print("실행 할 번호를 입력하세요 : ");
            int addOrRemoveOrModify = sc.nextInt();

            switch (addOrRemoveOrModify) {
                case 1:
                    System.out.print("추가 할 과목을 입력하세요 : ");
                    String addSubject = sc.next();
                    StudentList.getInstance().slist.get(idx).takingClass.add(addSubject);
                    break;
                case 2:
                    System.out.print("삭제 할 과목을 입력하세요 : ");
                    String removeSubject = sc.next();
                    StudentList.getInstance().slist.get(idx).takingClass.remove(removeSubject);
                    break;
                case 3:
                    returnMenu();
                    return;
                default:
                    System.out.println("1, 2, 3중에 하나를 입력하세요.");
            }
        }
    }
}


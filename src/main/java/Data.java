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

    public static int saveStudentData(int studentID, int age, String name, String major, ArrayList<String> takeclass, ArrayList<Student> slist) {
        slist.add(new Student(studentID, age, name, major, takeclass));
        return 1;
    }                                // 학생리스트에 학생정보 저장

    public static int modifyStudentData(int studentId, ArrayList<Student> slist) {

        int idx = searchStudentIdxNumberByStudentID(studentId, slist);

        if (idx == -1) {
            System.out.printf("입력하신 학번은 존재하지 않습니다");
            return -1;
        }
        return idx;
    }

    public static int modifyStudentDataInfo(int idx, int changeDataNumber, int ageToChange, String nameToChange, String majorToChange, ArrayList<Student> slist) {

        switch (changeDataNumber) {
            case 1:
                modifyStudentAge(idx, ageToChange, slist);
                return 1;
            case 2:
                modifyStudentName(idx, nameToChange, slist);
                return 2;
            case 3:
                modifyStudentMajor(idx, majorToChange, slist);
                return 3;
            case 4:
                modifyTakingClass(idx, slist);
                return 4;
            default:
                return 0;
        }
    }                              // 학생리스트에 학생정보 변경

    public static int removeStudentData(int idx, ArrayList<Student> slist) {

        if (idx == -1) {
            System.out.println("삭제할 학생이 없습니다.");
            return -1;
        } else {
            showStudentData(slist.get(idx));
            return 1;
        }
    }

    public static int removeStudentDataConfirm(int idx, boolean choice, ArrayList<Student> slist) {

        if (choice) {
            slist.remove(idx);
            System.out.println("삭제되었습니다.");
            return 1;
        } else {
            System.out.println("삭제를 취소합니다.");
            return 0;
        }
    }                              // 학생리스트에 학생정보 삭제


    /*****************
     * 아래부터는 정보은닉된 메소드입니다.
     *****************/

    public static void showWayToModify() {
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

    static boolean choiceSaveDataOrNot(String s) {

        if (s.compareTo("y") == 0 ||
                s.compareTo("Y") == 0 ||
                s.compareTo("yes") == 0 ||
                s.compareTo("Yes") == 0 ||
                s.compareTo("YES") == 0)
            return true;
        else
            return false;
    }

    public static boolean modifyStudentAge(int idx, int ageToChange, ArrayList<Student> slist) {
        slist.get(idx).age = ageToChange;
        return true;
    }

    public static boolean modifyStudentName(int idx, String nameToChange, ArrayList<Student> slist) {
        slist.get(idx).name = nameToChange;
        return true;
    }

    public static boolean modifyStudentMajor(int idx, String majorToChange, ArrayList<Student> slist) {
        slist.get(idx).major = majorToChange;
        return true;
    }

    private static void modifyTakingClass(int idx, ArrayList<Student> slist) {
        while (true) {
            System.out.println("현재 수강중인 과목 : ");
            for (int j = 0; j < slist.get(idx).takingClass.size(); j++)
                System.out.println(slist.get(idx).takingClass.get(j));
            System.out.println("1.추가    2.삭제    3.나가기");
            System.out.print("실행 할 번호를 입력하세요 : ");
            int addOrRemoveOrModify = inputInt();

            switch (addOrRemoveOrModify) {
                case 1:
                    System.out.print("추가 할 과목을 입력하세요 : ");
                    String addSubject = inputString();
                    slist.get(idx).takingClass.add(addSubject);
                    break;
                case 2:
                    System.out.print("삭제 할 과목을 입력하세요 : ");
                    String removeSubject = inputString();
                    slist.get(idx).takingClass.remove(removeSubject);
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


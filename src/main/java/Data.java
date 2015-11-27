import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

    private static Data datIinstance;
    private Data(){}

    public static Data getInstance(){
        if(datIinstance == null)
            datIinstance = new Data();

        return datIinstance;
    }

    public static void loadDataFromFile() throws IOException {

        File f = new File( "studentList.txt" );
        if ( f.canRead() ) {
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
        }
        else
            f.createNewFile();
    }

    public static void saveDataToFile() throws IOException {
        Writer write = new FileWriter( "studentList.txt" );
        BufferedWriter bWriter = new BufferedWriter( write );

        if (StudentList.getInstance().slist != null ) {

            for ( int i = 0; i < StudentList.getInstance().slist.size(); i ++ ) {

                bWriter.append("#\n");
                bWriter.append(String.valueOf(StudentList.getInstance().slist.get(i).studentID) + "\n" );
                bWriter.append(String.valueOf(StudentList.getInstance().slist.get(i).age) + "\n");
                bWriter.append(StudentList.getInstance().slist.get(i).name + "\n" );
                bWriter.append(StudentList.getInstance().slist.get(i).major + "\n" );

                for (int j = 0; j < StudentList.getInstance().slist.get(i).takingClass.size(); j++ ) {
                    bWriter.append(StudentList.getInstance().slist.get(i).takingClass.get(j) + "\n");
                }
                bWriter.flush();
            }
        }
        bWriter.close();
        write.close();
    }

    public void saveData() throws IOException {

        Scanner sc = new Scanner( System.in );

        ArrayList<String> takeclass = new ArrayList<String>();
        int studentID;
        int age;
        String name;
        String major;

        System.out.println( "========== 1. 데이터 추가 ===========");
        System.out.print("이름 : ");
        name = sc.next();

        System.out.print("학번 : ");
        studentID = sc.nextInt();

        System.out.print("나이 : ");
        age = sc.nextInt();

        System.out.print("전공 : ");
        major = sc.next();

        System.out.println("과목 입력을 멈추시려면 \"stop\"을 입력해 주세요.");
        int i = 1;
        while(true){
            System.out.printf("수강중인 과목 %d : ", i );
            String lecture = sc.next();
            if( lecture.compareTo( "stop" ) == 0 ) {
                break;
            }
            else {
                takeclass.add(lecture);
                i++;
            }
        }
        StudentList.getInstance().slist.add(new Student(studentID, age, name, major, takeclass));
        System.out.printf("현재 수강중인 과목(%d개) 저장되었습니다", i - 1 );
    }

    public void modifyData(){

       // TODO 학번 입력받아서 학생 정보 받아온 뒤에 원하는 정보 수정
        Scanner sc = new Scanner(System.in);
        int studentId;
        int changeDataNumber;
        System.out.print("변경 할 학번을 입력하세요 : ");
        studentId = sc.nextInt();

        while (true) {
            for (int i = 0; i < StudentList.getInstance().slist.size(); i++) {
                if (StudentList.getInstance().slist.get(i).studentID == studentId) {
                    System.out.println("====================");
                    System.out.println("데이터 수정");
                    System.out.println("1.나이");
                    System.out.println("2.이름");
                    System.out.println("3.전공");
                    System.out.println("4.수강중인 수업");
                    System.out.println("5.나가기");
                    System.out.print("수정할 데이터 번호를 입력하세요 : ");

                    changeDataNumber = sc.nextInt();

                    if (changeDataNumber == 1) {
                        System.out.println("현재 나이 : " + StudentList.getInstance().slist.get(i).age);
                        System.out.print("변경할 나이를 입력하세요 : ");
                        int ageToChange = sc.nextInt();
                        StudentList.getInstance().slist.get(i).age = ageToChange;
                    }

                    if (changeDataNumber == 2) {
                        System.out.println("현재 이름 : " + StudentList.getInstance().slist.get(i).name);
                        System.out.print("변경할 이름을 입력하세요 : ");
                        String nameToChange = sc.next();
                        StudentList.getInstance().slist.get(i).name = nameToChange;
                    }

                    if (changeDataNumber == 3) {
                        System.out.println("현재 전공 : " + StudentList.getInstance().slist.get(i).major);
                        System.out.print("변경할 전공을 입력하세요 : ");
                        String majorToChange = sc.next();
                        StudentList.getInstance().slist.get(i).major = majorToChange;
                    }

                    if (changeDataNumber == 4) {
                        while (true) {
                            System.out.println("현재 수강중인 과목 : ");
                            for (int j = 0; j < StudentList.getInstance().slist.get(i).takingClass.size(); j++)
                                System.out.println(StudentList.getInstance().slist.get(i).takingClass.get(j));
                            System.out.println("1.추가    2.삭제    3.나가기");
                            System.out.print("실행 할 번호를 입력하세요 : ");
                            int addOrRemoveOrModify = sc.nextInt();
                            if (addOrRemoveOrModify == 1) {
                                System.out.print("추가 할 과목을 입력하세요 : ");
                                String addSubject = sc.next();
                                StudentList.getInstance().slist.get(i).takingClass.add(addSubject);
                            }
                            if (addOrRemoveOrModify == 2) {
                                System.out.print("삭제 할 과목을 입력하세요 : ");
                                String removeSubject = sc.next();
                                StudentList.getInstance().slist.get(i).takingClass.remove(removeSubject);
                            }
                            if (addOrRemoveOrModify == 3)
                                return;
                        }
                    }
                    if (changeDataNumber == 5)
                        return;
                }
            }
        }
    }

    public void removeData() throws IOException {

        Scanner sc = new Scanner( System.in );
        int studentId;
        int i;

        System.out.print("지우고자 하는 학생의 학번을 입력해 주세요 : ");
        studentId = sc.nextInt();

        for(i = 0 ; i < StudentList.getInstance().slist.size() ; i++ ){
            if(StudentList.getInstance().slist.get(i).studentID == studentId) {
                StudentList.getInstance().slist.remove(i);
                System.out.println("삭제되었습니다.");
                return;
            }
        }
        if(i == StudentList.getInstance().slist.size()+1)
            System.out.println("삭제할 학생이 없습니다.");
    }
}

import java.io.FileNotFoundException;
import java.io.FileReader;
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

    // txt 파일에 있는 데이터를 읽어 slist에 저장시켜주는 메소드
    public static void loadDataFromFile() throws IOException {
        Reader read = new FileReader("studentList.txt");
        BufferedReader bReader = new BufferedReader(read);

        String tmp = bReader.readLine();
        while ( tmp != null && tmp.compareTo( "#" ) != 0 ) {
            if ( tmp.compareTo( "#" )  != 0 ) {
                String studentID = bReader.readLine();

                if ( studentID == null )
                    break;

                String age = bReader.readLine();
                String name = bReader.readLine();
                String major = bReader.readLine();
                ArrayList<String> takingClass = new ArrayList<String>();

                String temp = bReader.readLine();
                while ( temp != null && temp.compareTo( "#" ) != 0 ) {
                    takingClass.add(temp);
                    temp = bReader.readLine();
                }
                Student newStudent = new Student(Integer.parseInt(studentID), Integer.parseInt(age), name, major, takingClass);
                StudentList.getInstance().slist.add(newStudent);
            }
            else
                break;
        }

        bReader.close();
        read.close();
    }

    // txt 파일에 slist의 데이터를 써주는 메소드
    public static void saveDataToFile() throws IOException {
        Writer write = new FileWriter( "studentList.txt" );
        BufferedWriter bWriter = new BufferedWriter( write );

        if (StudentList.getInstance().slist != null ) {
            bWriter.write("#\n");

            int i = 0;
            while (StudentList.getInstance().slist != null) {

                bWriter.write(String.valueOf(StudentList.getInstance().slist.get(i).studentID) + "\n" );
                bWriter.write(String.valueOf(StudentList.getInstance().slist.get(i).age) + "\n" );
                bWriter.write(StudentList.getInstance().slist.get(i).name + "\n" );
                bWriter.write(StudentList.getInstance().slist.get(i).major + "\n" );
                bWriter.flush();

                int j = 0;
                while (StudentList.getInstance().slist.get(j) != null) {
                    bWriter.write(StudentList.getInstance().slist.get(i).takingClass.get(j) + "\n");
                    j++;
                }
                bWriter.flush();
                i++;
            }
        }
        bWriter.close();
        write.close();
    }

    // slist에 학생 정보를 저장하는 매소드
    public void saveData(){

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

    }

    public void removeData(){

        Scanner sc = new Scanner( System.in );
        int studentId;
        int i;

        System.out.print("지우고자 하는 학생의 학번을 입력해 주세요 : ");

        studentId = sc.nextInt();


        for(i = 0 ; i < StudentList.getInstance().slist.size() ; i++ ){
            if(StudentList.getInstance().slist.get(i).studentID == studentId)
                StudentList.getInstance().slist.remove( studentId );

        }

        if(i == StudentList.getInstance().slist.size()+1)
            System.out.println("삭제할 학생이 없습니다.");

    }

}


// TODO 학생 정보 저장
// TODO 학생 정보 수정
// TODO 학생 정보 삭제

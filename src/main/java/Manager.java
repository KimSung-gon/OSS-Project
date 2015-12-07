import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {

    public static void start() throws IOException {

        Data.getInstance().loadDataFromFile();

        boolean goOrStop = Administrators.loginStart();

        for (int i = 0; i < 15; i++)
            System.out.println();

        if (goOrStop == true)
            System.out.println("로그인 하였습니다");

        while (goOrStop) {


            try {
                Scanner sc = new Scanner(System.in);
                showMainMenu();

                int select = sc.nextInt();


                switch (select) {
                    case 1: {
                        ArrayList<String> takeclass = new ArrayList<String>();
                        int studentID;
                        int age;
                        String name;
                        String major;

                        System.out.println("========== 1. 데이터 추가 ===========");
                        System.out.print("이름 : ");
                        name = CommonStaticMethod.inputString();

                        System.out.print("학번 : ");
                        studentID = CommonStaticMethod.inputInt();

                        System.out.print("나이 : ");
                        age = CommonStaticMethod.inputInt();

                        System.out.print("전공 : ");
                        major = CommonStaticMethod.inputString();

                        System.out.println("과목 입력을 멈추시려면 \"stop\"을 입력해 주세요.");
                        int i = 1;

                        while (true) {
                            System.out.printf("수강중인 과목 %d : ", i);
                            String lecture = CommonStaticMethod.inputString();
                            if (lecture.compareTo("stop") == 0) {
                                break;
                            } else {
                                takeclass.add(lecture);
                                i++;
                            }
                        }

                        System.out.printf("현재 수강중인 과목(%d개) 저장되었습니다", i - 1);

                        Data.getInstance().saveStudentData(studentID, age, name, major, takeclass, StudentList.getInstance().slist);
                        break;
                    }
                    case 2: {
                        Data.getInstance().modifyStudentData();
                        break;
                    }
                    case 3: {

                        System.out.print("지우고자 하는 학생의 학번을 입력해 주세요 : ");
                        int studentId = CommonStaticMethod.askStudentID();
                        int idx = CommonStaticMethod.searchStudentIdxNumberByStudentID(studentId, StudentList.getInstance().slist);
                        if(idx != -1) {
                            Data.getInstance().removeStudentData(idx, StudentList.getInstance().slist);
                            System.out.printf("삭제하시겠습니까?( y/n ) : ");
                            boolean choice = Data.choiceSaveDataOrNot( CommonStaticMethod.inputString() );
                            Data.getInstance().removeStudentDataConfirm(idx, choice, StudentList.getInstance().slist);
                        }
                        CommonStaticMethod.returnMenu();
                        break;
                    }
                    case 4: {
                        System.out.println("찾고자 하는 학생의 학번을 입력해 주세요 : ");
                        int studentId = CommonStaticMethod.askStudentID();
                        int studentIdx = CommonStaticMethod.searchStudentIdxNumberByStudentID(studentId, StudentList.getInstance().slist);

                        Searching.searchDataOfStudent(studentIdx, StudentList.getInstance().slist);
                        CommonStaticMethod.returnMenu();
                        break;
                    }
                    case 5:
                        Searching.showAllData();
                        break;
                    case 6: {
                        System.out.print("찾고자 하는 과목명을 입력해 주세요 : ");
                        String subject = CommonStaticMethod.inputString();
                        int success = Searching.searchStudentDataOfSubject(subject, StudentList.getInstance().slist);
                        if(success == 0)
                            System.out.println("해당하는과목이 없습니다. 과목명을 확인해주세요.");
                        CommonStaticMethod.returnMenu();
                        break;
                    }
                    case 7: {
                        System.out.print("찾고자 하는 전공명을 입력해 주세요 : ");
                        String major = CommonStaticMethod.inputString();
                        int success = Searching.searchStudentDataOfMajor(major, StudentList.getInstance().slist);
                        if(success == 0)
                            System.out.println("해당하는 과가 없습니다. 전공명을 확인해주세요.");
                        CommonStaticMethod.returnMenu();
                        break;
                    }
                    case 8:{
                        System.out.print("찾고자 하는 입학년도를 네자리로 입력해 주세요 : ");
                        int year = Integer.parseInt(CommonStaticMethod.inputStringNumber());
                        int success = Searching.searchDataOfYear(year, StudentList.getInstance().slist);
                        if(success == 0)
                            System.out.println("해당하는 입학년도가 없습니다. 입학년도를 확인해주세요.");
                        CommonStaticMethod.returnMenu();
                        break;
                    }
                    case 9:
                        break;
                }
                Data.getInstance().saveDataToFile();
                if (select == 9)
                    return;
            }
            catch (InputMismatchException ex) {
                System.out.println("인풋 미스매치");

            } catch (NumberFormatException ex) {
                System.out.println("넘버 포맷 익셉션");
            }

        }
    }

    public static void showMainMenu() {

        for (int i = 0; i < 1; i++) {
            System.out.println();
        }

        System.out.printf("============== Menu ==============\n");
        System.out.printf("1. 데이터 추가\n");
        System.out.printf("2. 데이터 수정\n");
        System.out.printf("3. 데이터 삭제\n");
        System.out.printf("4. 학번을 통한 개인정보 상세 검색\n");
        System.out.printf("5. 저장된 학생 전체 정보에 대한 개요, 통계 출력\n");
        System.out.printf("6. 과목명에 따른 학생 검색\n");
        System.out.printf("7. 학과에 따른 학생 검색\n");
        System.out.printf("8. 입학년도에 따른 학생 검색\n");
        System.out.printf("9. 프로그램 종료\n");
        System.out.printf("==================================\n");
        System.out.printf("선택 : ");
    }
}

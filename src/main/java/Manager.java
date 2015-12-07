import java.io.*;
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
                        Data.getInstance().saveStudentData();
                        break;
                    }
                    case 2: {
                        Data.getInstance().modifyStudentData();
                        break;
                    }
                    case 3: {

                        System.out.print("지우고자 하는 학생의 학번을 입력해 주세요 : ");
                        int idx = CommonStaticMethod.searchStudentIdxNumberByStudentID(StudentList.getInstance());
                        System.out.println("idx = " + idx);
                        if(idx != -1) {
                            int confirm = Data.getInstance().removeStudentData(idx);
                            System.out.printf("삭제하시겠습니까?( y/n ) : ");
                            boolean choice = Data.choiceSaveDataOrNot( CommonStaticMethod.inputString() );
                            Data.getInstance().removeStudentDataConfirm(confirm, choice);
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("찾고자 하는 학생의 학번을 입력해 주세요 : ");
                        int studentIdx = CommonStaticMethod.searchStudentIdxNumberByStudentID(StudentList.getInstance());

                        Searching.searchDataOfStudent(studentIdx);
                        CommonStaticMethod.returnMenu();
                        break;
                    }
                    case 5:
                        Searching.showAllData();
                        break;
                    case 6: {
                        System.out.print("찾고자 하는 과목명을 입력해 주세요 : ");
                        String subject = CommonStaticMethod.inputString();
                        int success = Searching.searchStudentDataOfSubject(subject);
                        if(success == 0)
                            System.out.println("해당하는과목이 없습니다. 과목명을 확인해주세요.");
                        CommonStaticMethod.returnMenu();
                        break;
                    }
                    case 7: {
                        System.out.print("찾고자 하는 전공명을 입력해 주세요 : ");
                        String major = CommonStaticMethod.inputString();
                        int success = Searching.searchStudentDataOfMajor(major);
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

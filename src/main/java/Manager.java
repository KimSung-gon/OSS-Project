import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {

    public static void start () throws IOException ,InputMismatchException {

        Data.getInstance().loadDataFromFile();

        boolean goOrStop = Administrators.checkAdmin();

        for(int i=0; i<15; i++)
            System.out.println();

        if(goOrStop == true)
            System.out.println("로그인 하였습니다");

        while ( goOrStop ) {


            try {


                Scanner sc = new Scanner(System.in);
                showMainMenu();

                int select = sc.nextInt();


                switch (select) {
                    case 1:
                        Data.getInstance().saveStudentData();
                        break;
                    case 2:
                        Data.getInstance().modifyStudentData();
                        break;
                    case 3:
                        Data.getInstance().removeStudentData();
                        break;
                    case 4:
                        Searching.searchDataOfStudent();
                        break;
                    case 5:
                        Searching.showAllData();
                        break;
                    case 6:
                        Searching.searchStudentDataOfSubject();
                        break;
                    case 7:
                        Searching.searchStudentDataOfMajor();
                        break;
                    case 8:
                        Searching.searchDataOfYear();
                        break;
                    case 9:
                        break;
                }
                Data.getInstance().saveDataToFile();
                if (select == 9)
                    return;
            }

            catch (InputMismatchException ex){
                System.out.println("인풋 미스매치");

            }

        }
    }

    public static void showMainMenu () {

        for (int i = 0; i < 1; i ++ ) {
            System.out.println();
        }

        System.out.printf( "============== Menu ==============\n" );
        System.out.printf( "1. 데이터 추가\n" );
        System.out.printf( "2. 데이터 수정\n" );
        System.out.printf( "3. 데이터 삭제\n" );
        System.out.printf( "4. 학번을 통한 개인정보 상세 검색\n" );
        System.out.printf( "5. 저장된 학생 전체 정보에 대한 개요, 통계 출력\n" );
        System.out.printf( "6. 과목명에 따른 학생 검색\n" );
        System.out.printf( "7. 학과에 따른 학생 검색\n" );
        System.out.printf( "8. 입학년도에 따른 학생 검색\n" );
        System.out.printf( "9. 프로그램 종료\n" );
        System.out.printf( "==================================\n" );
        System.out.printf( "선택 : " );
    }
}

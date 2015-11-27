import java.io.*;
import java.util.Scanner;

public class Manager {

    public static void start () throws IOException {

        Data.getInstance().loadDataFromFile();

        while ( true ) {

            Scanner sc = new Scanner( System.in );
            showMainMenu();
            int select = sc.nextInt();

            switch ( select ) {
                case 1:
                    Data.getInstance().saveData();
                    Data.getInstance().saveDataToFile();
                    break;
                case 2:
                    Data.getInstance().modifyData();
                    Data.getInstance().saveDataToFile();
                    break;
                case 3:
                    Data.getInstance().removeData();
                    Data.getInstance().saveDataToFile();
                    break;
                case 4:
                    Searching.searchDataOfStudent();
                    break;
                case 5:
                    Searching.showAllData();
                    break;
                case 6:
                    Searching.searchDataOfSubject();
                    break;
                case 7:
                    Searching.searchDataOfMajor();
                    break;
                case 8:
                    Searching.searchDataOfYear();
                    break;
                case 9:
                    Data.getInstance().saveDataToFile();
                    return;

            }
        }
    }

    public static void showMainMenu () {

        for (int i = 0; i < 100; i ++ ) {
            System.out.println("");
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

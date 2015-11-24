import java.io.IOException;
import java.util.Scanner;

public class Manager {

    public static void start () throws IOException {

        Data.getInstance().loadDataFromFile();
        Scanner sc = new Scanner( System.in );

        while ( true ) {
            showMainMenu();
            int select = sc.nextInt();

            switch ( select ) {
                case 1:
                    Data.getInstance().saveData();
                    break;
                case 2:
                    Data.getInstance().modifyData();
                    break;
                case 3:
                    Data.getInstance().removeData();
                    break;
                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
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

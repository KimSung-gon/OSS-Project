import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class DataTest {

    ArrayList<Student> testsList = new ArrayList<Student>();

    public void setUp() {

        ArrayList<String> testClass1 = new ArrayList<String>();
        testClass1.add("모바일프로그래밍");
        testClass1.add("선형대수");
        testClass1.add("응용통계학");
        testClass1.add("이산수학");
        testsList.add(new Student(20110001, 24, "일번학생", "컴퓨터공학", testClass1));

        ArrayList<String> testClass2 = new ArrayList<String>();
        testClass2.add("미분과적분");
        testClass2.add("선형대수");
        testClass2.add("응용통계학");
        testsList.add(new Student(20110002, 24, "이번학생", "수학", testClass2));

        ArrayList<String> testClass3 = new ArrayList<String>();
        testClass3.add("모바일프로그래밍");
        testClass3.add("선형대수");
        testClass3.add("응용통계학");
        testClass3.add("이산수학");
        testsList.add(new Student(20110003, 24, "삼번학생", "컴퓨터공학", testClass3));

        ArrayList<String> testClass4 = new ArrayList<String>();
        testClass3.add("모바일프로그래밍");
        testClass3.add("선형대수");
        testClass3.add("응용통계학");
        testClass3.add("이산수학");
        testsList.add(new Student(20100003, 24, "사번학생", "컴퓨터공학", testClass3));
    }
    @Test
    public void saveStudentDataTest(){
        setUp();
        ArrayList<String> takeClass = new ArrayList<String>();
        takeClass.add("OSS");
        TestCase.assertEquals(1, Data.saveStudentData(20113300, 24, "윤명식", "컴퓨터공학", takeClass, testsList));
    }

    @Test
    public void removeStudentDataTest(){
        setUp();
        TestCase.assertEquals(1, Data.removeStudentData(0, testsList));   // 삭제할 학생이 존재함
        TestCase.assertEquals(-1, Data.removeStudentData(-1, testsList)); // 삭제할 학생이 존재하지 않음
    }

    @Test
    public void removeStudentDataConfirm(){
        setUp();
        TestCase.assertEquals(0, Data.removeStudentDataConfirm(0,false, testsList)); // 삭제학생 존재할때, 삭제하지않음
        TestCase.assertEquals(1, Data.removeStudentDataConfirm(0,true, testsList));  // 샂게학생 존재할떄, 삭제함
    }

    @Test
    public void choiceSaveDataOrNot () {

        String str1 = "Y";
        String str2 = "y";
        String str3 = "Yes";
        String str4 = "YES";
        String str5 = "no";
        String str6 = "NO";
        String str7 = "N";
        String str8 = "AAA";
        String str9 = "1234";
        String str10 = "asdfasdf";
        String str11 = "네";
        String str12 = "아니오";
        String str13 = "";

        TestCase.assertTrue ( Data.choiceSaveDataOrNot( str1 ) );
        TestCase.assertTrue ( Data.choiceSaveDataOrNot( str2 ) );
        TestCase.assertTrue ( Data.choiceSaveDataOrNot( str3 ) );
        TestCase.assertTrue ( Data.choiceSaveDataOrNot( str4 ) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str5 ) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str6 ) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str7 ) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str8) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str9) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str10) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str11) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str12) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str13) );
    }



}

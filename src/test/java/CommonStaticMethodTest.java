import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class CommonStaticMethodTest {
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
    public void searchStudentIdxNumberByStudentIDTest(){
        setUp();
        TestCase.assertEquals(0, CommonStaticMethod.searchStudentIdxNumberByStudentID(20110001, testsList));
        TestCase.assertEquals(1, CommonStaticMethod.searchStudentIdxNumberByStudentID(20110002, testsList));
        TestCase.assertEquals(2, CommonStaticMethod.searchStudentIdxNumberByStudentID(20110003, testsList));
        TestCase.assertEquals(3, CommonStaticMethod.searchStudentIdxNumberByStudentID(20100003, testsList));
        TestCase.assertEquals(-1, CommonStaticMethod.searchStudentIdxNumberByStudentID(21321412, testsList));

    }

    @Test
    public void isNumberic () {
        String testStr1 = "123";
        String testStr2 = "a123";
        String testStr3 = "1a23";
        String testStr4 = "12a3";
        String testStr5 = "가나다";
        String testStr6 = "112i2234";
        String testStr7 = "112630k";
        String testStr8 = "number";
        String testStr9 = " 123";

        TestCase.assertTrue( CommonStaticMethod.isNumeric(testStr1) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr2) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr3) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr4) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr5) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr6) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr7) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr8) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr9) );

    }


}

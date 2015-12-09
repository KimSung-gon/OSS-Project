import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class SearchingTest {

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
    public void searchDataOfStudentTest() {
        setUp();
        TestCase.assertEquals(1, Searching.searchDataOfStudent(0, testsList));
        TestCase.assertEquals(1, Searching.searchDataOfStudent(1, testsList));
        TestCase.assertEquals(1, Searching.searchDataOfStudent(2, testsList));
        TestCase.assertEquals(0, Searching.searchDataOfStudent(-1, testsList));
    }

    @Test
    public void searchStudentDataOfSubjectTest() {

        setUp();
        TestCase.assertEquals(1, Searching.searchStudentDataOfSubject("이산수학", testsList));
        TestCase.assertEquals(1, Searching.searchStudentDataOfSubject("모바일프로그래밍", testsList));
        TestCase.assertEquals(0, Searching.searchStudentDataOfSubject("영어", testsList));
        TestCase.assertEquals(0, Searching.searchStudentDataOfSubject("틀린입력", testsList));
        TestCase.assertEquals(0, Searching.searchStudentDataOfSubject("afdsaewfawef", testsList));
        TestCase.assertEquals(0, Searching.searchStudentDataOfSubject("!@#%$!@%#!@#$", testsList));
    }

    @Test
    public void searchStudentDataOfMajorTest() {

        setUp();
        TestCase.assertEquals(1, Searching.searchStudentDataOfMajor("컴퓨터공학", testsList));
        TestCase.assertEquals(1, Searching.searchStudentDataOfMajor("수학", testsList));
        TestCase.assertEquals(0, Searching.searchStudentDataOfMajor("틀린학과입력", testsList));
        TestCase.assertEquals(0, Searching.searchStudentDataOfMajor("adsfaewf", testsList));
        TestCase.assertEquals(0, Searching.searchStudentDataOfMajor("!@#$!^!$#%", testsList));

    }

    @Test
    public void serchDataOfYear() {

        setUp();
        TestCase.assertEquals(0, Searching.searchDataOfYear(2000, testsList));
        TestCase.assertEquals(1, Searching.searchDataOfYear(2010, testsList));
        TestCase.assertEquals(1, Searching.searchDataOfYear(2011, testsList));
        TestCase.assertEquals(0, Searching.searchDataOfYear(2012, testsList));
        TestCase.assertEquals(0, Searching.searchDataOfYear(12341245, testsList));
    }

}

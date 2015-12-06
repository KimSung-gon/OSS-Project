import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;

public class SearchingTest {

    ArrayList<Student> testsList = new ArrayList<Student>();

    @Test
    public void setUp(){
        ArrayList<String> testClass1 = new ArrayList<String>();
        testClass1.add("모바일프로그래밍");
        testClass1.add("선형대수");
        testClass1.add("응용통계학");
        testClass1.add("이산수학");
        testsList.add(new Student(20110001, 24, "일번학생", "컴퓨터공학" , testClass1));

        ArrayList<String> testClass2 = new ArrayList<String>();
        testClass2.add("미분과적분");
        testClass2.add("선형대수");
        testClass2.add("응용통계학");
        testsList.add(new Student(20110002, 24, "이번학생", "수학" , testClass2));

        ArrayList<String> testClass3 = new ArrayList<String>();
        testClass3.add("모바일프로그래밍");
        testClass3.add("선형대수");
        testClass3.add("응용통계학");
        testClass3.add("이산수학");
        testsList.add(new Student(20110003, 24, "삼번학생", "컴퓨터공학" , testClass3));
    }

    @Test
    public void serchDataOfYearTest(){

        TestCase.assertEquals(0, Searching.searchDataOfYear(0000, testsList));
    }

}

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class CommonStaticMethodTest {

    @Test
    public void searchStudentIdxNumberByStudentID () {

//        ArrayList<Student>slist = new ArrayList<Student>();
//        StudentList testList = new StudentList( slist );


    }







    @Test
    public void showStudentID () {

        Student s1 = new Student( 20150001, 20, "홍길동", "컴퓨터공학", null );
        Student s2 = new Student( 20150002, 20, "홍길동", "컴퓨터공학", null );

        TestCase.assertEquals(20150001, CommonStaticMethod.showStudentID( s1 ));
        TestCase.assertEquals(20150002, CommonStaticMethod.showStudentID( s2 ));
    }

    @Test
    public void showStudentName () {
        Student s1 = new Student( 20150001, 20, "홍길동", "컴퓨터공학", null );
        Student s2 = new Student( 20150002, 20, "김철수", "컴퓨터공학", null );

        TestCase.assertEquals( "홍길동", CommonStaticMethod.showStudentName( s1 ) );
        TestCase.assertEquals( "김철수", CommonStaticMethod.showStudentName( s2 ) );
    }

    @Test
    public void showStudentAge () {
        Student s1 = new Student( 20150001, 20, "홍길동", "컴퓨터공학", null );
        Student s2 = new Student( 20150002, 21, "김철수", "컴퓨터공학", null );

        TestCase.assertEquals( 20, CommonStaticMethod.showStudentAge(s1) );
        TestCase.assertEquals( 21, CommonStaticMethod.showStudentAge(s2) );
    }

    @Test
    public void showStudentMajor (){

        Student s1 = new Student( 20150001, 20, "홍길동", "컴퓨터공학", null );
        Student s2 = new Student( 20150002, 21, "김철수", "경제학", null );

        TestCase.assertEquals( "컴퓨터공학", CommonStaticMethod.showStudentMajor(s1) );
        TestCase.assertEquals( "경제학", CommonStaticMethod.showStudentMajor(s2) );
    }



}

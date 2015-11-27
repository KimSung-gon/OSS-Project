import org.junit.Test;

import java.util.ArrayList;

public class SearchingTest {

    @Test
    public void searchDataOfStudentTest(){
        ArrayList<String> takingClass = new ArrayList<String>();
        takingClass.add("english");
        takingClass.add("math");
        takingClass.add("computer");
        StudentList.getInstance().slist.add(new Student(20113300, 24, "MyoungSik", "CS", takingClass));

    }

}

import java.util.ArrayList;

public class StudentList {

    private static StudentList slInstance;
    ArrayList<Student> slist;

    private StudentList() {
        slist = new ArrayList<Student>();
    }

    public static StudentList getInstance() {
        if (slInstance == null)
            slInstance = new StudentList();

        return slInstance;
    }

}

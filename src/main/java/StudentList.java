import java.util.ArrayList;

public class StudentList {

    private static StudentList instance;
    ArrayList<Student> slist;

    private StudentList(){
        slist = new ArrayList<Student>();
    }

    public static StudentList getInstance(){
        if(instance == null)
            instance = new StudentList();

        return instance;
    }

}

import java.util.ArrayList;

public class Main {
    public static void main ( String[] args ) {


        Data db = new Data();

        db.saveData();

        System.out.println(StudentList.getInstance().slist.get(0).name);

        //Manager.start();

    }
}



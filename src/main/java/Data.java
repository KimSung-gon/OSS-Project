import java.util.ArrayList;

public class Data {

    private static Data datIinstance;

    private Data(){}

    public static Data getInstance(){
        if(datIinstance == null)
            datIinstance = new Data();

        return datIinstance;
    }

    public void saveData(){
        ArrayList<String> takeclass = new ArrayList<String>();
        takeclass.add("Math");
        takeclass.add("English");
        StudentList.getInstance().slist.add(new Student(20113300, 24, "MS", "CS", takeclass));
    }

    public void modifyData(){

    }

    public void removeData(){

    }

}


// TODO 학생 정보 저장
// TODO 학생 정보 수정
// TODO 학생 정보 삭제

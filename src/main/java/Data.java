import java.util.ArrayList;

public class Data {

    public Data(){

    }

    public void saveData(){
        ArrayList<String> takeclass = new ArrayList<String>();
        takeclass.add("Math");
        takeclass.add("English");
        StudentList.getInstance().slist.add(new Student(20113300, 24, "MS", "CS", takeclass));
    }


}


// TODO 학생 정보 저장
// TODO 학생 정보 수정
// TODO 학생 정보 삭제

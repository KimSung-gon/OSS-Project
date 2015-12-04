public class Searching extends CommonStaticMethod {

    public static void searchDataOfStudent() {
        System.out.println("찾고자 하는 학생의 학번을 입력해 주세요 : ");
        int studentIdx = searchStudentIdxNumberByStudentID();

        if (studentIdx == -1) {
            System.out.println("조회되는 학번이 없습니다.");
        } else {
            showdata(StudentList.getInstance().slist.get(studentIdx));
        }
        returnMenu();
    }                  // 학번을 통한 정보 검색

    public static void showAllData() {

        for (int i = 0; i < StudentList.getInstance().slist.size(); i++)
            showdata(StudentList.getInstance().slist.get(i));

        System.out.println("\n총 학생 수 : " + StudentList.getInstance().slist.size());
        returnMenu();
    }                          // 전체 학생수, 모든 학생데이터 출력

    public static void showdata(Student student) {

        System.out.println("===========================");
        System.out.println("\n학번 : " + student.studentID);
        System.out.println("나이 : " + student.age);
        System.out.println("이름 : " + student.name);
        System.out.println("전공 : " + student.major);

        System.out.println("\n수강중인 과목");
        for (int j = 0; j < student.takingClass.size(); j++)
            System.out.println("[" + (j + 1) + "]" + student.takingClass.get(j));
        System.out.println("===========================");
    }              // 학생 개인정보 출력

    public static void searchStudentDataOfSubject() {
        System.out.print("찾고자 하는 과목명을 입력해 주세요 : ");
        String subject = inputString();
        for (int i = 0; i < StudentList.getInstance().slist.size(); i++)
            for (int j = 0; j < StudentList.getInstance().slist.get(i).takingClass.size(); j++)
                if (StudentList.getInstance().slist.get(i).takingClass.get(j).compareTo(subject) == 0)
                    showStudentIdAndName(StudentList.getInstance().slist.get(i));
        returnMenu();
    }           // 과목을 통한 정보 검색

    public static void searchStudentDataOfMajor() {
        System.out.print("찾고자 하는 전공명을 입력해 주세요 : ");
        String major = inputString();
        for (int i = 0; i < StudentList.getInstance().slist.size(); i++)
            if (StudentList.getInstance().slist.get(i).major.compareTo(major) == 0)
                showStudentIdAndName(StudentList.getInstance().slist.get(i));
        returnMenu();
    }             // 전공을 통한 정보 검색

    public static void searchDataOfYear() {
        System.out.print("찾고자 하는 입학년도를 네자리로 입력해 주세요 : ");
        int year = Integer.parseInt(inputStringNumber());
        for (int i = 0; i < StudentList.getInstance().slist.size(); i++)
            if (StudentList.getInstance().slist.get(i).studentID / 10000 == year)
                showStudentIdAndName(StudentList.getInstance().slist.get(i));
        returnMenu();
    }                     // 학번을 통한 정보 검색


}

// TODO showAllData 학생 정보 단순 나열 > 정보 가공해서 출력하도록 리팩토링 요


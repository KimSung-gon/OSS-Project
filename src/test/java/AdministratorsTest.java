import junit.framework.TestCase;
import org.junit.Test;

public class AdministratorsTest {

    Administrators admin = new Administrators();

    @Test
    public void loginPasswordLoopTest() {

        TestCase.assertTrue(admin.loginPasswordLoop(true));
        TestCase.assertFalse(admin.loginPasswordLoop(false));

    }       // 비밀번호 루프에는 입력을 받으므로 한계가 있음

    @Test
    public void loginStartTest() {

        TestCase.assertEquals(admin.loginPasswordLoop(true), admin.loginStart());
        TestCase.assertEquals(admin.loginStart(), admin.loginPasswordLoop(true));
        TestCase.assertEquals(admin.loginPasswordLoop(false),admin.loginStart());
        TestCase.assertEquals(admin.loginStart(), admin.loginPasswordLoop(false));

    }       // 로그인 창은 입력받으므로 테스트의 한계가 있음

    @Test
    public void IDexistTest() {

        TestCase.assertTrue(admin.IDexist("fharenheit"));
        TestCase.assertTrue(admin.IDexist("20091130"));
        TestCase.assertTrue(admin.IDexist("20103308"));
        TestCase.assertTrue(admin.IDexist("20113300"));

        TestCase.assertFalse(admin.IDexist("12342323"));
        TestCase.assertFalse(admin.IDexist("111"));
        TestCase.assertFalse(admin.IDexist("100000000000000"));
        TestCase.assertFalse(admin.IDexist("일번학생"));
        TestCase.assertFalse(admin.IDexist("컴퓨터공학과"));
        TestCase.assertFalse(admin.IDexist("abcdefgh"));
        TestCase.assertFalse(admin.IDexist("abcd efgh"));
        TestCase.assertFalse(admin.IDexist(" "));
        TestCase.assertFalse(admin.IDexist(""));

    }             // 아이디 존재여부 확인

    @Test
    public void IndexNumberOfIDTest() {

        TestCase.assertEquals(0, admin.IndexNumberOfID("fharenheit"));
        TestCase.assertEquals(1, admin.IndexNumberOfID("20091130"));
        TestCase.assertEquals(2, admin.IndexNumberOfID("20103308"));
        TestCase.assertEquals(3, admin.IndexNumberOfID("20113300"));

        TestCase.assertEquals(-1, admin.IndexNumberOfID("20000000"));
        TestCase.assertEquals(-1, admin.IndexNumberOfID("123213"));
        TestCase.assertEquals(-1, admin.IndexNumberOfID("십일번"));
        TestCase.assertEquals(-1, admin.IndexNumberOfID("ab cd"));
        TestCase.assertEquals(-1, admin.IndexNumberOfID(" "));
        TestCase.assertEquals(-1, admin.IndexNumberOfID(""));
        TestCase.assertEquals(-1, admin.IndexNumberOfID("12341212"));

    }                             // 관리자학번 인덱스값 리턴

    @Test
    public void checkPasswordTest() {

        TestCase.assertTrue(admin.checkPassword(0, "rlaqudrhs"));
        TestCase.assertFalse(admin.checkPassword(1, "rlaqudrhs"));
        TestCase.assertFalse(admin.checkPassword(2, "rlaqudrhs"));
        TestCase.assertFalse(admin.checkPassword(3, "rlaqudrhs"));

        TestCase.assertFalse(admin.checkPassword(0, "dlaehdgns"));
        TestCase.assertTrue(admin.checkPassword(1, "dlaehdgns"));
        TestCase.assertFalse(admin.checkPassword(2, "dlaehdgns"));
        TestCase.assertFalse(admin.checkPassword(3, "dlaehdgns"));

        TestCase.assertFalse(admin.checkPassword(0, "rlatjdrhs"));
        TestCase.assertFalse(admin.checkPassword(1, "rlatjdrhs"));
        TestCase.assertTrue(admin.checkPassword(2, "rlatjdrhs"));
        TestCase.assertFalse(admin.checkPassword(3, "rlatjdrhs"));

        TestCase.assertFalse(admin.checkPassword(0, "dbsaudtlr"));
        TestCase.assertFalse(admin.checkPassword(1, "dbsaudtlr"));
        TestCase.assertFalse(admin.checkPassword(2, "dbsaudtlr"));
        TestCase.assertTrue(admin.checkPassword(3, "dbsaudtlr"));

        TestCase.assertFalse(admin.checkPassword(0, "abcdefgh"));
        TestCase.assertFalse(admin.checkPassword(1, "abcdefgh"));
        TestCase.assertFalse(admin.checkPassword(2, "abcdefgh"));
        TestCase.assertFalse(admin.checkPassword(3, "abcdefgh"));

        TestCase.assertFalse(admin.checkPassword(0, "fharenheit"));
        TestCase.assertFalse(admin.checkPassword(1, "20091130"));
        TestCase.assertFalse(admin.checkPassword(2, "20103308"));
        TestCase.assertFalse(admin.checkPassword(3, "20113300"));

    }         // 비밀번호 확인
}
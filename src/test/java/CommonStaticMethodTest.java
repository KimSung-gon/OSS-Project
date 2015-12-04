import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class CommonStaticMethodTest {

    @Test
    public void isNumberic () {
        String testStr1 = "123";
        String testStr2 = "a123";
        String testStr3 = "1a23";
        String testStr4 = "12a3";
        String testStr5 = "가나다";
        String testStr6 = "112i2234";
        String testStr7 = "112630k";
        String testStr8 = "number";
        String testStr9 = " 123";

        TestCase.assertTrue( CommonStaticMethod.isNumeric(testStr1) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr2) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr3) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr4) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr5) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr6) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr7) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr8) );
        TestCase.assertFalse( CommonStaticMethod.isNumeric(testStr9) );

    }


}

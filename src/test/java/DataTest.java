import junit.framework.TestCase;
import org.junit.Test;

public class DataTest {

    @Test
    public void choiceSaveDataOrNot () {

        String str1 = "Y";
        String str2 = "y";
        String str3 = "Yes";
        String str4 = "YES";
        String str5 = "no";
        String str6 = "NO";
        String str7 = "N";
        String str8 = "AAA";
        String str9 = "1234";
        String str10 = "asdfasdf";
        String str11 = "네";
        String str12 = "아니오";
        String str13 = "";

        TestCase.assertTrue ( Data.choiceSaveDataOrNot( str1 ) );
        TestCase.assertTrue ( Data.choiceSaveDataOrNot( str2 ) );
        TestCase.assertTrue ( Data.choiceSaveDataOrNot( str3 ) );
        TestCase.assertTrue ( Data.choiceSaveDataOrNot( str4 ) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str5 ) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str6 ) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str7 ) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str8) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str9) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str10) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str11) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str12) );
        TestCase.assertFalse ( Data.choiceSaveDataOrNot( str13) );
    }



}

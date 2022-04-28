package llibreria.tests;
import org.opentest4j.AssertionFailedError;
import llibreria.values.AsciiChars;
import org.junit.jupiter.api.Assertions;
public class MyTests {
    private static int test_count = 0;
    private static String TEST_PASSED;
    private static String TEST_FAILED;

    public static void runTests(test... tests){
        for (test test : tests) {
            loadMessages();
            try {
                test.unitaryTest();
                System.out.println(TEST_PASSED);
            } catch (AssertionFailedError ex) {
                System.out.println(TEST_FAILED);
            }
        }
    }
    void v(int... nums){}
    public static interface test {
        abstract void unitaryTest() throws AssertionFailedError;
    }
    public static void assertEquals(Object expected, Object actual) throws AssertionFailedError {
        Assertions.assertEquals(expected, actual);
    }
    private static void loadMessages(){
        test_count++;
        TEST_PASSED = "\u001B[32m"+AsciiChars.CHECK_MARK+" test "+test_count+" passed";
        TEST_FAILED = "\u001B[31m"+AsciiChars.BALLOT_X + " test "+test_count+" failed";
    }
}

import static org.junit.Assert.*;

import org.junit.Test;


public class JUnitHelloWorldTests {

    @Test
    public void testNumberOfDigitsOrdinaryNumber() {
        assertEquals(1, JUnitHelloWorld.getNumberOfDigits(7));
        assertEquals(2, JUnitHelloWorld.getNumberOfDigits(42));
    }
    
    @Test
    public void testNumberOfDigitsBigNumberWithVisualSeparator() {
        assertEquals(6, JUnitHelloWorld.getNumberOfDigits(222_222));
    }
    
    @Test
    public void testNumberOfDigitsNegativeNumber() {
        assertEquals(2, JUnitHelloWorld.getNumberOfDigits(-22));
    }
}

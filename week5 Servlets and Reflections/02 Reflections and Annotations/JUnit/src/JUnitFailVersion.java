public class JUnitFailVersion {

    public static boolean assertTrue(boolean condition) {
        return condition == true;
    }

    public static boolean assertFalse(boolean condition) {
        return condition == false;
    }

    public static boolean assertEquals(Object expected, Object actual) {
        return expected == actual;
    }

    public static boolean assertNull(Object object) {
        return object == null;
    }

    public static boolean assertNotNull(Object object) {
        return object != null;
    }

}

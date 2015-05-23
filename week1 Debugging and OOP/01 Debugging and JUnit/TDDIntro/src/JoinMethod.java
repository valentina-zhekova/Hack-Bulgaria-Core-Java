import java.util.Collection;


public class JoinMethod {
    public static String stichMeUp(Object glue, Object... stuffs) {
        String result = stuffs[0].toString();
        for (int i = 1; i < stuffs.length; i++) {
            result += glue.toString() + stuffs[i].toString();
        }
        return result;
    }
}

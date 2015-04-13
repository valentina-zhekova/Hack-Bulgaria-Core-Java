import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class ReverseCollection {

    public static Collection reverse(Collection input) {
        Iterator i = input.iterator();
        ArrayList helper = new ArrayList<>();
        while (i.hasNext()) {
            helper.add(0, i.next());
        }
        input.clear();
        input.addAll(helper);
        return input;
    }

    public static void main(String[] args) {
        ArrayList<Integer> example = new ArrayList<Integer>();
        example.add(2);
        example.add(3);
        example.add(2);
        example.add(4);
        System.out.println(example.toString());
        System.out.println(ReverseCollection.reverse(example).toString());
    }
}

import java.util.Arrays;
import java.util.Collection;
import java.util.Spliterator;
import java.util.stream.StreamSupport;


public class Main {
    public static void main(String[] args) {
        Collection<String> testCollection = Arrays.asList("This","is","a","lame","example");
        Spliterator<String> yourSpliterator = new SlidingWindowSpliterator(testCollection, 2); //2 is the sliding window length
        StreamSupport.stream(yourSpliteratorObject).forEach(System.out::println);
    }
}

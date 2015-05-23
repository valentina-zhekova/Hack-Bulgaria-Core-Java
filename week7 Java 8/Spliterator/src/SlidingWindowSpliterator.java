import java.util.Collection;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SlidingWindowSpliterator implements Spliterator<T> {

    public SlidingWindowSpliterator(Collection<T> testCollection, int s) {}
    
    @Override
    public boolean tryAdvance(Consumer action) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Spliterator trySplit() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long estimateSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int characteristics() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class RaceCondition {
    public static Integer counter = 0;
    //public static AtomicInteger counter = new AtomicInteger();
    
    //public static synchronized void increment() {
    //    counter++;
    //}
    
    // hmm, is it so?:
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new A());
        Thread b = new Thread(new B());
        
        long startTime = System.currentTimeMillis();
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(counter);
        System.out.println(System.currentTimeMillis() - startTime);
        
        // non sync: 2006250, cause of concurrency; 8 milisec
        // sync before for with (this) v1: 3901196 => obviously wrong; 7 milisec
        // sync before for with (RaceCondition.class) v2: 4000000; 11 milisec
        // sync before for with ((Integer) RaceCondition.counter) v2: 4000000; 14 milisec
        // sync before counter++ with ((Integer) RaceCondition.counter)): 4000000; 51 milisec
        // sync run: 4000000; 12 milisec
        // ***sync increment in Runnable: 3915550; 56 milisec
        // AtomicInteger (addAndGet(1)): 4000000; 104 milisec
        // 
    }
}

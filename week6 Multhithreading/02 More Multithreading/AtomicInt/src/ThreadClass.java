
public class ThreadClass implements Runnable {
    public void run() {
        MainClass.counter.addAndGet(1);
    }
}

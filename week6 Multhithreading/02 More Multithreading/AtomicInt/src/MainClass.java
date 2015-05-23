
public class MainClass {
    public static AtomicInt counter = new AtomicInt();
    
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new ThreadClass());
        Thread b = new Thread(new ThreadClass());
        Thread c = new Thread(new ThreadClass());
        long startTime = System.currentTimeMillis();
        a.start(); b.start(); c.start();
        a.join(); b.join(); c.join();
        System.out.println(counter.toString());
        System.out.println(System.currentTimeMillis() - startTime);
    }
}

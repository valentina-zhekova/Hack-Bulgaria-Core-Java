public class A implements Runnable {
    // public synchronized void increment() {
    // RaceCondition.counter++;
    // }

    public void run() {
        synchronized (RaceCondition.lock) {
            while ((Integer) RaceCondition.counter % 2000000 != 0) {
            //while (!RaceCondition.lock.tryLock()) {
                try {
                    RaceCondition.lock.wait();
                } catch (InterruptedException e) {
                }
            }

            RaceCondition.lock.lock();
            try {
                for (int i = 0; i < 2_000_000; i++)
                    RaceCondition.counter++;
            } finally {
                RaceCondition.lock.unlock();
                RaceCondition.lock.notify();
            }

        }
    }
}

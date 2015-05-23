import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicInt {
    private int integer;
    private Lock lock = new ReentrantLock();

    // //////////////// CONSTRUCTORS ////////////////////////

    // AtomicInteger()
    // Creates a new AtomicInteger with initial value 0.
    public AtomicInt() {
        integer = 0;
    }

    // AtomicInteger(int initialValue)
    // Creates a new AtomicInteger with the given initial value.
    public AtomicInt(int initialValue) {
        integer = initialValue;
    }

    // //////////////// ATOMIC METHODS ////////////////////////

    // int addAndGet(int delta)
    // Atomically adds the given value to the current value.
    public int addAndGet(int delta) {
        lock.lock();
        try {
            // for (int i = 0; i < 4200; i++) {
            //     System.out.println(Thread.currentThread().getName());
            integer += delta;
            // }
        } finally {
            lock.unlock();
        }
        return integer;
    }

    // int decrementAndGet()
    // Atomically decrements by one the current value.
    public int decrementAndGet() {
        lock.lock();
        try {
            integer--;
        } finally {
            lock.unlock();
        }
        return integer;
    }

    // int incrementAndGet()
    // Atomically increments by one the current value.
    public int incrementAndGet(int delta) {
        lock.lock();
        try {
            integer += delta;
        } finally {
            lock.unlock();
        }
        return integer;
    }

    // int getAndAdd(int delta)
    // Atomically adds the given value to the current value.
    public int getAndAdd(int delta) {
        int rememberOld = integer;
        lock.lock();
        try {
            integer += delta;
        } finally {
            lock.unlock();
        }
        return rememberOld;
    }

    // int getAndDecrement()
    // Atomically decrements by one the current value.
    public int getAndDecrement(int delta) {
        int rememberOld = integer;
        lock.lock();
        try {
            integer--;
        } finally {
            lock.unlock();
        }
        return rememberOld;
    }

    // int getAndIncrement()
    // Atomically increments by one the current value.
    public int getAndIncrement(int delta) {
        int rememberOld = integer;
        lock.lock();
        try {
            integer++;
        } finally {
            lock.unlock();
        }
        return rememberOld;
    }

    // int getAndSet(int newValue)
    // Atomically sets to the given value and returns the old value.
    public int getAndSet(int delta) {
        int rememberOld = integer;
        lock.lock();
        try {
            integer = delta;
        } finally {
            lock.unlock();
        }
        return rememberOld;
    }

    // boolean compareAndSet(int expect, int update)
    // Atomically sets the value to the given updated value if the current value
    // == the expected value.
    public boolean compareAndSet(int expect, int update) {
        boolean is_successfull = false;
        lock.lock();
        try {
            if (expect == integer) {
                integer = update;
                is_successfull = true;
            }
        } finally {
            lock.unlock();
        }
        return is_successfull;
    }

    // boolean weakCompareAndSet(int expect, int update)
    // Atomically sets the value to the given updated value if the current value
    // == the expected value.
    public boolean weakCompareAndSet(int expect, int update) {
        return compareAndSet(expect, update);
    }

    // //////////////// NON-ATOMIC METHODS ////////////////////////

    // int get()
    // Gets the current value.
    public int get() {
        return integer;
    }

    // void set(int newValue)
    // Sets to the given value.
    public void set(int newValue) {
        integer = newValue;
    }

    // void lazySet(int newValue)
    // Eventually sets to the given value.
    public void lazySet(int newValue) {
        set(newValue);
    }

    // String toString()
    // Returns the String representation of the current value.
    public String toString() {
        return String.valueOf(integer);
    }

    // //////////////// NON-ATOMIC METHODS FROM NUMBER ////////////////////////

    // double doubleValue()
    // Returns the value of the specified number as a double.
    public double doubleValue() {
        return (double) integer;
    }

    // float floatValue()
    // Returns the value of the specified number as a float.
    public float floatValue() {
        return (float) integer;
    }

    // int intValue()
    // Returns the value of the specified number as an int.
    public int intValue() {
        return integer;
    }

    // long longValue()
    // Returns the value of the specified number as a long.
    public long longValue() {
        return (long) integer;
    }
}

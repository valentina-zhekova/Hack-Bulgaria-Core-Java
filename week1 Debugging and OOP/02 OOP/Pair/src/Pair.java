final public class Pair { // hmmmmmmm?
    final private Object obj1;
    final private Object obj2;
    
    Pair(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    
    public Object getObj1() {
        return obj1;
    }
    
    public Object getObj2() {
        return obj2;
    }
    
    public String toString() {
        // hmmmmm?
        return String.format("object 1: %s\nobject 2: %s\n", obj1, obj2);
    }
    
    public boolean equals(Object other) {
        if (other instanceof Pair) {
            Pair otherPair = (Pair) other; // hmmmmm?
            return (obj1 == otherPair.obj1) && (obj2 == otherPair.obj2);
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Pair p1 = new Pair(1, 2);
        Pair p2 = new Pair(1, 3);
        System.out.println(p1.equals(p2));
    }
}

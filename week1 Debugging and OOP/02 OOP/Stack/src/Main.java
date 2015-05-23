
public class Main {
    public static void main(String[] args) {
        StackImpl<Integer> stack = new StackImpl<Integer>();
        stack.push(2);
        stack.push(22);
        System.out.println("The stack:\n" + stack.toString());
        System.out.println("The length is: " + stack.length());
        System.out.println("Just removed: " + stack.pop());
        System.out.println("Now the length is: " + stack.length());
        stack.clear();
        System.out.println("Is empty after clearing: " + stack.isEmpty());
        stack.push(42);
        System.out.println("New stack content:\n" + stack.toString());
        System.out.println("Pushing with pushUnique() existing element: " + stack.pushUnique(42));
        System.out.println("Pushing with pushUnique() new element: " + stack.pushUnique(101));
        System.out.println("New stack content:\n" + stack.toString());
    }
}

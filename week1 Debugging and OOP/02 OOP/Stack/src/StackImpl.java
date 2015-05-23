
public class StackImpl<T> implements Stack<T> {

    private class Node {
        T value = null;
        Node parent = null;
        
        Node(T value, Node parent) {
            this.value = value;
            this.parent = parent;
        }
    }
    
    private Node top;
    private int size;
    
    public StackImpl() {
        top = new Node(null, null);
        size = 0;
    }
    
    public void push(T element) {
        Node parent = top;
        top = new Node(element, parent);
        size ++;
    }
    
    public boolean pushUnique(T element) {
        boolean flag = true;
        Node current = top;
        while(current.parent != null) {
            if (current.value == element) {
                flag = false;
                break;
            }
            current = current.parent;
        }
        if (flag == true) {
            push(element);
        }
        return flag;
    }
    
    public T pop() {
        T result = top.value;
        Node previous = top.parent;
        top = previous;
        size --;
        return result;
    }
    
    public int length() {
        return size;
    }
    
    public void clear() {
        while(top.parent != null) {
            pop();
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public String toString() {
        String result = "";
        Node current = top;
        while(current.parent != null) {
            result += current.value.toString() + "\n";
            current = current.parent;
        }
        return result;
    }
}

public class Node<T> {
    public T value;
    public Node next = null;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }
}
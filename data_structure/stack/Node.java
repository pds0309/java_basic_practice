package stack;

public class Node<T> {
    public T item;
    public Node next;

    public Node(T item) {
        this.item = item;
        this.next = null;
    }

    public void linkNext(Node node) {
        this.next = node;
    }

    public Node getNext() {
        return next;
    }
}
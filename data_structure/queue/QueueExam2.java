package queue;

import stack.Node;

public class QueueExam2 {
    public static void main(String[] args) {
        MyLLQueue<Integer> ml = new MyLLQueue<>();
        ml.add(5);
        ml.add(4);
        ml.add(3);
        System.out.println(ml.pop());
        System.out.println(ml.peek());
    }
}

class MyLLQueue<T> {
    // 삭제연산만 할 front
    private Node front;
    // 삽입연산만 할 rear
    private Node rear;

    public MyLLQueue() {
        this.front = null;
        this.rear = null;
    }

    public void add(T data) {
        Node n = new Node(data);
        if (isEmpty()) {
            front = n;
            rear = n;
            return;
        }
        rear.linkNext(n);
        rear = n;
    }

    public T peek() {
        return (T) front.item;
    }

    public T pop() {
        Node n = front;
        front = front.getNext();
        return (T) n.item;
    }

    public boolean isEmpty() {
        return front == null && rear == null;
    }
}



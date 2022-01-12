package queue;


public class QueueExam1 {
    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<>(5);
        mq.add(5);
        mq.add(4);
        mq.add(3);
        System.out.println(mq.pop());
        System.out.println(mq.peek());
    }
}

class MyQueue<T> {
    private int rear;
    private int front;
    private T[] queue;
    private int size;

    public MyQueue(int size) {
        this.size = size;
        queue = (T[]) new Object[size];
        front = 0;
        rear = 0;
    }

    public void add(T data) {
        if (!isFull()) {
            this.queue[rear++] = data;
        }
    }

    public T pop() {
        if (!isEmpty()) {
            return queue[front++];
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return queue[front];
        }
        return null;
    }

    private boolean isFull() {
        return rear == size - 1;
    }

    public boolean isEmpty() {
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        return front == rear;
    }
}

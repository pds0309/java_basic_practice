package stack;


public class StackExam {
    public static void main(String[] args) {

        MyStack<Integer> myIntStack = new MyStack<>(5);
        myIntStack.push(5);
        myIntStack.peek();
        myIntStack.pop();
    }
}
class MyStack<T> {

    T[] stack;
    int top;
    int size;

    public MyStack(int size) {
        this.size = size;
        stack = (T[]) new Object[size];
        top = -1;
    }

    public void push(T item) {
        if (!isFull()) {
            stack[++top] = item;
        }
    }

    public T pop() {
        if (!isEmpty()) {
            return stack[top--];
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return stack[top];
        }
        return null;
    }

    private boolean isFull() {
        return this.top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}


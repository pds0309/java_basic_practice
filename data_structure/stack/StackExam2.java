package stack;

public class StackExam2 {
    public static void main(String[] args) {
        MyLLStack<Integer> myl = new MyLLStack<>();
        myl.push(5);
        myl.push(4);
        myl.push(3);
        myl.pop();
        System.out.println(myl.peek());
    }
}



class MyLLStack<T> {
    Node top;

    public MyLLStack() {
        this.top = null;
    }

    public void push(T data) {
        // 입력받은 새로운 데이터에 대한 노드 생성
        Node n = new Node(data);
        //현재 top 위치에 있는 노드에 새로 생성된 노드를 다음 데이터로써 연결함
        n.linkNext(top);
        top = n;
    }

    public void pop() {
        top = top.getNext();
    }

    public T peek() {
        return (T) top.item;
    }
}

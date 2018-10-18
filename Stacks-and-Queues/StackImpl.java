public class StackImpl {
    public static void main(String args[]) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(2);
        stack.push(6);
        stack.push(9);

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}

class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        private StackNode(T data) {
            this.data = data;
        }
    }

    StackNode<T> top;

    T pop() {
        if (top == null) return null;
        T item = top.data;
        top = top.next;
        return item;
    }

    void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    T peek() {
        if (top == null) return null;
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
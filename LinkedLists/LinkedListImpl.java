public class LinkedListImpl {
    public static void main(String args[]) {
        MyLinkedList list = new MyLinkedList();
        System.out.println(list.length);
        list.add(5);

        System.out.println(list.length);
        list.add(7);
        list.add(6);

        System.out.println(list.getFirst().data);
        System.out.println(list.getLast().data);
        System.out.println(list.length);

        System.out.println(list.removeLast().data);
        System.out.println(list.removeFirst().data);
        System.out.println(list.length);
    }
}

class MyLinkedList {
    Node head;
    Node tail;
    int length;

    class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList(){
        this.length = 0;
    }

    public void add(int val){
        Node node = new Node(val);
        if(tail!=null)
            tail.next = node;
        if(head == null)
            head = node;
        tail = node;
        this.length++;
    }

    public Node getFirst(){
        return this.length == 0 ? null : head;
    }

    public Node getLast(){
        return this.length == 0 ? null : tail;
    }

    public Node removeFirst(){
        if(this.length == 0)
            return null;
        Node old = head;
        head = head.next;
        this.length--;
        return old;
    }

    public Node removeLast(){
        if(this.length == 0)
            return null;
        Node temp = head;
        while(temp.next != null && temp.next.next != null){
            temp = temp.next;
        }
        Node old = temp.next;
        temp.next = null;
        this.length--;
        return old;
    }
}
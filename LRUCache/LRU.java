import java.util.*;

public class LRU {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}

class LRULinkedListNode{
    int value, key;
    LRULinkedListNode next, prev;

    public LRULinkedListNode(int key, int value){
        this.value = value;
        this.key = key;
    }
}

class LRUCache {
    HashMap<Integer, LRULinkedListNode> map;
    int capacity, used;
    LRULinkedListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.used = 0;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        LRULinkedListNode node = map.get(key);
        if(node == null) return -1;

        if(used == 1 || node == head) return node.value;

        if(capacity > 1){
            if(node.prev != null){
                node.prev.next = node.next;
                if(node.next == null) tail = node.prev;
            }

            if(node.next != null){
                node.next.prev = node.prev;
                if(node.next == null) node.next.prev = null;
            }

            node.next = head;
            head.prev = node;
            node.prev = null;

            head = node;
        }

        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value = value;
            get(key);
            return;
        }

        LRULinkedListNode newNode = new LRULinkedListNode(key, value);

        if(used >= capacity){
            if(capacity>1){
                map.remove(tail.key);
                tail.prev.next = null;
                tail = tail.prev;
            }else{
                map.remove(tail.key);
                head = newNode;
                tail = newNode;
                map.put(key, newNode);
            }

        }

        if(this.used == 0){
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        used++;
        map.put(key, newNode);
        return;
    }
}
import java.util.*;

/* Java code for depth first and breadth first search */
public class DFSandBFS {
    public static void main(String args[]) {

        // Initialise graph nodes
        Node<Integer> node0 = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);

        // Initialise adjacency lists
        node0.addToList(node1);
        node0.addToList(node4);
        node0.addToList(node5);
        node1.addToList(node3);
        node1.addToList(node4);
        node2.addToList(node1);
        node3.addToList(node2);
        node3.addToList(node4);

        // Run Breadth First Search
        System.out.println(BFS(node0));

        // Reset all nodes visited status back to false
        node0.setVisited(false);
        node1.setVisited(false);
        node2.setVisited(false);
        node3.setVisited(false);
        node4.setVisited(false);
        node5.setVisited(false);

        // Run Depth First Search
        System.out.println(DFS(node0, new ArrayList<>()));
    }

    // Breadth First Search
    static ArrayList<Integer> BFS(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        result.add((Integer) node.getData());

        while (!queue.isEmpty()) {
            Node q = queue.remove();

            if (q != null) {
                ArrayList<Node> adj = q.getAdj();
                for (Node n : adj) {
                    if (!n.getVisited()) {
                        result.add((Integer) n.getData());
                        queue.add(n);
                        n.setVisited(true);
                    }
                }
            }
        }
        return result;
    }

    // Depth First Search
    static ArrayList<Integer> DFS(Node node, ArrayList<Integer> result) {
        if (node == null) return null;
        result.add((Integer) node.getData());
        node.setVisited(true);

        ArrayList<Node> adj = node.getAdj();
        for (Node n : adj) {
            if (!n.getVisited()) {
                DFS(n, result);
            }
        }
        return result;
    }
}

// Node class
class Node<T> {
    private T data;
    private ArrayList<Node> list;
    private boolean visited = false;

    Node(T data) {
        this.data = data;
        this.list = new ArrayList<>();
    }

    void addToList(Node node) {
        list.add(node);
    }

    ArrayList<Node> getAdj() {
        return list;
    }

    T getData() {
        return data;
    }

    boolean getVisited() {
        return visited;
    }

    void setVisited(boolean visited) {
        this.visited = visited;
    }
}
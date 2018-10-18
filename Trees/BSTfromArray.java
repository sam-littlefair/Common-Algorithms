/* Generates a binary search tree from a sorted int array */

public class BSTfromArray {
    public static void main(String args[]) {
        //Even length array
        int[] array1 = {1,4,5,7,8,9,13,14,17,19,21,25};
        Node head = getMinTree(array1, 0, array1.length-1);
        inOrder(head);

        System.out.println();

        //Odd length array
        int[] array2 = {3,6,8};
        head = getMinTree(array2, 0, array2.length-1);
        inOrder(head);
    }

    //Print the nodes In Order (will appear in same order as in array)
    public static void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    //Recursively generate a BST using (pretty much) binary search
    public static Node getMinTree(int[] array, int min, int max){
        if (min > max) return null;
        int mid = (int) (max + min) / 2;
        Node newNode = new Node(array[mid]);
        newNode.left = getMinTree(array, min, mid-1);
        newNode.right = getMinTree(array, mid+1, max);
        return newNode;
    }
}

//Node class
class Node{
    public int data;
    public Node left;
    public Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
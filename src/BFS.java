/**
 * Created by Dell on 16-11-2016.
 */
import java.util.*;
import java.io.*;

 //Node of a tree
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}

//Breadth First Search
public class BFS {
    /* Taking input as:
        First line representing the number of nodes in the tree
        Subsequent lines proving an integer denoting value of
        each node that must be added to the BST

        Sample input:
        6
        3
        5
        4
        7
        2
        1
        */
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }


    //Creating a BST while inserting a node at a time
    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    //Performing BFS and printing each node level by level
    static void levelOrder(Node root){
        if (root == null) {
            System.out.println("No nodes in the tree");
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        // Enqueue Root
        queue.add(root);

        while (queue.peek() != null) {
            // nodeCount (queue size) indicates
            // number of nodes at current level.
            int nodeCount = queue.size();

            // Dequeue all nodes of current level and
            // Enqueue all nodes of next level
            while (nodeCount > 0) {
                Node newNode = queue.peek();
                queue.remove();
                System.out.print(newNode.data + " ");
                if (newNode.left != null)
                    queue.add(newNode.left);
                if (newNode.right != null)
                    queue.add(newNode.right);
                nodeCount--;
            }
        }
    }
}

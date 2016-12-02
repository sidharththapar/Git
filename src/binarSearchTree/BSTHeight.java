package binarSearchTree;
import java.util.*;
import java.io.*;


/**
 * Created by Dell on 03-11-2016.
 */
public class BSTHeight {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height;
        height = getHeight(root);
        System.out.println(height);
    }


    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList();

        // Enqueue Root and initialize height
        q.add(root);
        int height = 0;

        while (true) {
            // nodeCount (queue size) indicates
            // number of nodes at current level.
            int nodeCount = q.size();
            if (nodeCount == 0) {
                return height - 1;
            }

            height++;


            // Dequeue all nodes of current level and
            // Enqueue all nodes of next level
            while (nodeCount > 0) {
                Node newNode = q.peek();
                q.remove();
                if (newNode.left != null)
                    q.add(newNode.left);
                if (newNode.right != null)
                    q.add(newNode.right);
                nodeCount--;
            }

        }
    }
}





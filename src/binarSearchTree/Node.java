package binarSearchTree;

/**
 * Created by Dell on 03-11-2016.
 */
public class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
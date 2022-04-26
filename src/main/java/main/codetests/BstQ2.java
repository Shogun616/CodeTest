package main.codetests;

import java.util.Arrays;
import java.util.function.IntConsumer;

class Node {
    Node left;
    Node right;
    int data;
}

class Bst {

    public Node insert(Node node, int val) {
        if(node == null) {
            return createNewNode(val);
        }

        if(val < node.data) {
            node.left = insert(node.left, val);
        } else if((val > node.data)) {
            node.right = insert(node.right, val);
        }

        return node;
    }

    public Node createNewNode(int k) {
        Node a = new Node();
        a.data = k;
        a.left = null;
        a.right = null;
        return a;
    }

    public Node delete(Node node, int val) {
        if(node == null) {
            return null;
        }

        if(val < node.data) {
            node.left = delete(node.left, val);
        } else if(val > node.data) {
            node.right = delete(node.right, val);
        } else {
            if(node.left == null || node.right == null) {
                Node temp = node.left != null ? node.left : node.right;

                return temp;
            } else {
                Node successor = getSuccessor(node);
                node.data = successor.data;

                node.right = delete(node.right, successor.data);
                return node;
            }
        }
        return node;
    }

    public Node getSuccessor(Node node) {
        if(node == null) {
            return null;
        }

        Node temp = node.right;

        while(temp.left != null) {
            temp = temp.left;
        }

        return temp;
    }

    private boolean contains(Node node, int value){
        if(node == null){
            return false;
        }
        if (value == node.data){
            return true;
        }
        return value < node.data
                ? contains(node.left, value)
                : contains(node.right, value);
    }

    Node root;
    public void containsNode(int value){
        contains(root, value);
    }

    void iterateOrder(IntConsumer consumer) {
        final int[] ints = {3, 7, 10, 13, 14};
        Arrays.stream(ints).peek(consumer).mapToObj(x -> x + " ").forEach(System.out::print);
    }
}

public class BstQ2 {

    public static void main(String[] args) {
        Bst a = new Bst();
        Node root = null;

        root = a.insert(root, 8);
        root = a.insert(root, 3);
        root = a.insert(root, 6);
        root = a.insert(root, 10);
        root = a.insert(root, 4);
        root = a.insert(root, 7);
        root = a.insert(root, 1);
        root = a.insert(root, 14);
        root = a.insert(root, 13);

        root = a.delete(root, 4);

        a.containsNode(10);
        Node finalRoot = root;

        System.out.println((a.getSuccessor(root)) + "");
        System.out.println(root.left.data);
        System.out.println(root.right.data);
        a.iterateOrder(value -> a.getSuccessor(finalRoot));
    }
}

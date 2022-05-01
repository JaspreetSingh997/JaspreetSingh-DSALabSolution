package BST;

import java.util.*;

public class SumPair {

    static class Node {
        int nodeData;
        Node leftNode, rightNode;
    };
 
    static Node NewNode(int data)
    {
        Node temp = new Node();
        temp.nodeData = data;
        temp.leftNode = null;
        temp.rightNode = null;
        return temp;
    }
 
    static Node insert(Node root, int key)
    {
        if (root == null)
            return NewNode(key);
        if (key < root.nodeData)
            root.leftNode = insert(root.leftNode, key);
        else
            root.rightNode = insert(root.rightNode, key);
        return root;
    }
 
    static boolean findpairUtil(Node root, int sum, HashSet<Integer> set)
    {
        if (root == null)
            return false;
 
        if (findpairUtil(root.leftNode, sum, set))
            return true;
 
        if (set.contains(sum - root.nodeData)) {
            System.out.println("Pair is (" + (sum - root.nodeData) + ", " + root.nodeData + ")");
            return true;
        }
        else
            set.add(root.nodeData);
 
        return findpairUtil(root.rightNode, sum, set);
    }
 
    static void findPair(Node root, int sum)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        if (!findpairUtil(root, sum, set))
            System.out.print("Pairs do not exist" + "\n");
    }
 
    // main method
    public static void main(String[] args)
    {
        Node root = null;
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 60);
 
        int sum = 80;
        findPair(root, sum);
    }
}

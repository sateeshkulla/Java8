package com.learn.collections;

import java.util.Arrays;

public class TreeNode {

    public static void main(String args[]) {
        String[] elements = { "g", "f", "e", "d", "c", "b", "a"};
        Arrays.sort(elements);

        Node parentNode = new Node(elements[0]);
        Node currentNode = parentNode;
        for (int i = 1; i <= elements.length - 1; i++) {
            //parentNode = addNode(parentNode, elements[i]);

            if (currentNode.rightNode != null && currentNode.leftNode != null
                    && currentNode.leftNode.leftNode == null) {
                currentNode = currentNode.leftNode;
            } else if (currentNode.rightNode != null && currentNode.leftNode != null
                    && currentNode.rightNode.rightNode == null) {
                currentNode = currentNode.rightNode;
            }

            if (currentNode.leftNode == null) {
                Node leftNode = new Node(elements[i]);
                currentNode.leftNode = leftNode;
                continue;
            }
            if (currentNode.rightNode == null) {
                Node rightNode = new Node(elements[i]);
                currentNode.rightNode = rightNode;
                continue;
            }
            }

        System.out.println(parentNode);

    }
    
    private static Node addNode(Node rootNode, String value) {
        /* If root is null, return null */
        if (rootNode == null) {
            return null;
        }
        /* Create a new node */
        Node newNode = new Node(value);
        /* Compare with the root, if small, insert left else insert right */
        if ((newNode.data).compareTo(rootNode.data) < 0) {
            if (rootNode.leftNode != null) {
                rootNode.leftNode = addNode(rootNode.leftNode, value);
            } else {
                rootNode.leftNode = newNode;
            }
        } else {
            if (rootNode.rightNode != null) {
                rootNode.rightNode = addNode(rootNode.rightNode, value);
            } else {
                rootNode.rightNode = newNode;
            }
        }
        /* Increase the size and return rootNode */
        return rootNode;
       /* if (current == null) {
            return new Node(value);
        }
     
        if (value.compareTo(current.data) < 0) {
            current.leftNode = addRecursive(current.leftNode, value);
        } else if (value.compareTo(current.data) > 0) {
            current.rightNode = addRecursive(current.rightNode, value);
        } else {
            // value already exists
            return current;
        }
     
        return current;*/
    }
    
    public static void insert(Node node, String value) {
        if (value.compareTo(node.data) < 0)
        {
            if (node.leftNode != null)
            {
                insert(node.leftNode, value);
            } 
            else
            {     
                node.leftNode = new Node(value);
            }
        } 
        else if (value.compareTo(node.data) > 0)
        {
            if (node.rightNode != null)
            {
                insert(node.rightNode, value);
            }
            else
            {
                node.rightNode = new Node(value);
            }
        }
    }

}

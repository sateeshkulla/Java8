package com.learn.collections;

public class Bst {
    
    public static Node createNode(String value){
        return new Node(value);
    }
    
    public static Node insertNode(Node node, String value){
        if (node == null){
            return new Node(value);
        }
        
        if(value.compareTo(node.data) <= 0){
            node.leftNode = insertNode(node.leftNode, value);
        } else if (value.compareTo(node.data) > 0){
            node.rightNode = insertNode(node.rightNode, value);
        }
        return node;
    }

    public static void main(String[] args) {
        String[] values = {"a", "b", "d", "e", "c", "f", "g"};
        Node rootNode = null;
        for(String value : values){
            rootNode = insertNode(rootNode, value);
        }
        /*rootNode = insertNode(rootNode, "d");
        rootNode = insertNode(rootNode, "b");
        rootNode = insertNode(rootNode, "e");
        rootNode = insertNode(rootNode, "a");
        rootNode = insertNode(rootNode, "f");
        rootNode = insertNode(rootNode, "c");
        rootNode = insertNode(rootNode, "g");*/
        //rootNode = insertNode(rootNode, 13);
        System.out.println(rootNode);

    }

}

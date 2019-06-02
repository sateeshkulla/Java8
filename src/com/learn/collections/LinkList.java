package com.learn.collections;


public class LinkList {
    
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

    }
    
    Node head;
    int size = 0;
    
    public LinkList(){
        head = null;
        size = 0;
    }
    
    public void addElement(int data){
        if (head == null){
            size++;
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        size++;
        current.next = new Node(data);
    }
    
    public void addElementFirst(int data){
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
        size++;
    }
    
    public void deleteElement(int data){
        Node current = head;
        while (current.next != null){
            if (current.next.data == data){
                size--;
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
}

package com.learn.collections;

import org.junit.Assert;

public class Stack<T extends Comparable<T>> {

    int size = 0;
    Node<T> top;

    public void push(T data) {
        Node<T> current = new Node<T>(data, top);
        this.top = current;
        size++;
    }

    public T pop() {
        T value = top.getData();
        top = top.getNext();
        size--;
        return value;
    }

    public T peek() {
        return top.getData();
    }

    public int size() {
        return size;
    }

    public class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getData() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public int compareTo(T o) {
            return value.toString().compareTo(o.toString());
        }
    }

    public static class MinStack<T> {
        Stack<Integer> elements = new Stack<>();
        Stack<Integer> min = new Stack<>();
        Stack<Integer> max = new Stack<>();

        public void push(Integer data) {
            elements.push(data);
            if (min.top == null || data < min.peek()) {
                min.push(data);
            }
            if (max.top == null || data > max.peek()) {
                max.push(data);
            }
        }

        public Integer pop() {
            Integer value = elements.pop();
            if (value == min.peek()) {
                min.pop();
            }
            if (value == max.peek()) {
                max.pop();
            }
            return value;
        }

        public Integer peek() {
            return elements.peek();
        }

        public Integer min() {
            return min.peek();
        }
        
        public Integer max() {
            return max.peek();
        }

        public Integer size() {
            return elements.size();
        }
    }

    public static void main(String[] args) {
        MinStack<Integer> stack = new MinStack<>();
        stack.push(02);
        stack.push(18);
        stack.push(11);
        stack.push(12);
        stack.push(15);
        stack.push(19);
        stack.push(01);
        Assert.assertTrue(stack.size() == 07);
        Assert.assertTrue(stack.peek() == 01);
        Assert.assertTrue(stack.min() == 01);
        Assert.assertTrue(stack.max() == 19);
        Assert.assertTrue(stack.pop() == 01);
        Assert.assertTrue(stack.peek() == 19);
        Assert.assertTrue(stack.min() == 02);
        Assert.assertTrue(stack.size() == 06);
        Assert.assertTrue(stack.pop() == 19);
        Assert.assertTrue(stack.max() == 18);
        System.out.println("Done");
    }

}

package com.Bernie.tree;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/10/25 16:30
 */
public class Node {
    int data;
    Node leftNode;
    Node rightNode;

    public Node(int data) {
        this.data = data;
    }

    public void display() {
        System.out.println(data);
    }

    public void show() {
        System.out.print(data + " ");
    }
}

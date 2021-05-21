package com.Bernie.tree;

import java.util.*;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/10/25 16:34
 */
public class BinaryTree implements Tree{
    // 根节点
    private Node rootNode;

    public Node find(int key) {
        Node currentNode = rootNode;
        while (currentNode != null) {
            if (currentNode.data > key) {
                currentNode = currentNode.leftNode;
            } else if (currentNode.data < key) {
                currentNode = currentNode.rightNode;
            } else {
                return currentNode;
            }
        }
        return null;
    }

    public boolean insert(int data) {
        Node newNode = new Node(data);
        if (null == rootNode) {
            rootNode = newNode;
            return true;
        }
        Node currentNode = rootNode;
        Node parentNode = null;
        while (currentNode != null) {
            parentNode = currentNode;
            if (currentNode.data > data) {
                currentNode = currentNode.leftNode;
                if (currentNode == null) {
                    parentNode.leftNode = newNode;
                    return true;
                }
            } else {
                currentNode = currentNode.rightNode;
                if (currentNode == null) {
                    parentNode.rightNode = newNode;
                    return true;
                }
            }
        }
        return false;
    }

    //中序遍历
    // left > root > right
    public void infixOrder(Node current) {
        if (current !=null) {
            infixOrder(current.leftNode);
            System.out.print(current.data + " ");
            infixOrder(current.rightNode);
        }
    }

    @Override
    public List<Node> infixOrderByStack(Node current) {
        List<Node> res = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        while (null != current || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftNode;
            }
            Node node = stack.peek();
            stack.pop();
            res.add(node);
            current = node.rightNode;
        }

        return res;
    }

    // 前序遍历
    // root > preOrder(left) > preOrder(right)
    public void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preOrder(current.leftNode);
            preOrder(current.rightNode);
        }
    }

    // 前序遍历的栈实现
    @Override
    public List<Node> preOrderByStack(Node current) {
        List<Node> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(current);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            stack.pop(); // 出栈
            res.add(node);
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }

            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
        }

        return res;
    }

    // 后序遍历
    // left > right > root
    public void postOrder(Node current) {
        if (current != null) {
            postOrder(current.leftNode);
            postOrder(current.rightNode);
            System.out.print(current.data + " ");
        }
    }

    public Node findMax() {
        Node currentNode = rootNode;
        Node maxNode = currentNode;
        while (currentNode !=null) {
            maxNode = currentNode;
            currentNode = currentNode.rightNode;
        }
        return maxNode;
    }

    public Node findMin() {
        Node currentNode = rootNode;
        Node minNode = currentNode;
        while (currentNode != null) {
            minNode = currentNode;
            currentNode = currentNode.leftNode;
        }
        return minNode;
    }

    public boolean delete(int key) {
        return false;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(50);
        binaryTree.insert(20);
        binaryTree.insert(80);
        binaryTree.insert(10);
        binaryTree.insert(30);
        binaryTree.insert(60);
        binaryTree.insert(90);
        binaryTree.insert(25);
        binaryTree.insert(85);
        binaryTree.insert(100);
        System.out.println("--------");
        binaryTree.find(90).display();
        System.out.println("中序遍历：");
        binaryTree.infixOrder(binaryTree.rootNode);
        System.out.println("\n-------------------");
        System.out.println("中序遍历(栈实现)：");
        List<Node> res = binaryTree.infixOrderByStack(binaryTree.rootNode);
        res.forEach(Node::show);
        binaryTree.infixOrder(binaryTree.rootNode);
        System.out.println("\n-------------------");
        System.out.println("中序遍历(自定义迭代器)：");
        BinaryTreeIterator binaryTreeIterator = new BinaryTreeIterator(binaryTree.rootNode);
        while (binaryTreeIterator.hasNext()) {
            System.out.print(binaryTreeIterator.next() + " ");
        }
        System.out.println("\n-------------------");
        System.out.println("前序遍历(递归实现):");
        binaryTree.preOrder(binaryTree.rootNode);
        System.out.println("\n-------------------");
        System.out.println("前序遍历(栈实现):");
        List<Node> preList = binaryTree.preOrderByStack(binaryTree.rootNode);
        preList.forEach(Node::show);
        System.out.println("\n-------------------");
        System.out.println("后序遍历:");
        binaryTree.postOrder(binaryTree.rootNode);
        System.out.println("\n-------------------");
        System.out.println("最大值：");
        binaryTree.findMax().display();
        System.out.println("最小值：");
        binaryTree.findMin().display();
    }
}

package com.Bernie.tree;

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

    // 前序遍历
    // root > preOrder(left) > preOrder(right)
    public void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preOrder(current.leftNode);
            preOrder(current.rightNode);
        }
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
        System.out.println("前序遍历:");
        binaryTree.preOrder(binaryTree.rootNode);
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

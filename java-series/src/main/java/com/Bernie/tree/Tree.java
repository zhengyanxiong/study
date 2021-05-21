package com.Bernie.tree;

import java.util.List;

/**
 * create by: Bernie
 * description: TODO
 * create time: 2020/10/25 16:33
 */
public interface Tree {
    //查找节点
    public Node find(int key);
    //插入新节点
    public boolean insert(int data);

    //中序遍历
    public void infixOrder(Node current);
    public List<Node> infixOrderByStack(Node current);
    //前序遍历
    public void preOrder(Node current);
    //通过栈实现
    public List<Node> preOrderByStack(Node current);
    //后序遍历
    public void postOrder(Node current);

    //查找最大值
    public Node findMax();
    //查找最小值
    public Node findMin();

    //删除节点
    public boolean delete(int key);
}

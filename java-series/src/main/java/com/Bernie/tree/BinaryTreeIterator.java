package com.Bernie.tree;

import java.util.*;

/**
 * @author Bernie
 * @Date 2021/03/29 18:27
 */
public class BinaryTreeIterator implements Iterator<Integer> {
    private List<Integer> iteratorList;
    private Iterator<Integer> treeIterator;

    BinaryTreeIterator(Node node) {
        iteratorList = new ArrayList<>();
        dfs(node);
        treeIterator = iteratorList.iterator();
    }

    private void dfs(Node node) {
        Deque<Node> stack = new LinkedList<>();
        Node curr = node;
        while (curr != null || !stack.isEmpty()) {
            while (null != curr) {
                stack.push(curr);
                curr = curr.leftNode;
            }
            curr = stack.peek();
            stack.pop();
            iteratorList.add(curr.data);
            curr = curr.rightNode;
        }
    }

    @Override
    public boolean hasNext() {
        return treeIterator.hasNext();
    }

    @Override
    public Integer next() {
        return treeIterator.next();
    }
}

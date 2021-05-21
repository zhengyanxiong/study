//给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
//
// 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: [1,1,2,1,1]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: [1,4,6]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
// 
// Related Topics 栈 设计 
// 👍 237 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class FlattenNestedListIterator {
    public static void main(String[] args) {
        //Solution solution = new FlattenNestedListIterator().new Solution();
        FlattenNestedListIterator flattenNestedListIterator = new FlattenNestedListIterator();
        List<NestedInteger> nestedIntegers = new ArrayList<>();

        List<NestedInteger> nestedIntegers1 = new ArrayList<>();
        nestedIntegers1.add(flattenNestedListIterator.new Nested(1));
        nestedIntegers1.add(flattenNestedListIterator.new Nested(1));

        List<NestedInteger> nestedIntegers2 = new ArrayList<>();
        nestedIntegers2.add(flattenNestedListIterator.new Nested(1));
        nestedIntegers2.add(flattenNestedListIterator.new Nested(1));

        nestedIntegers.add(flattenNestedListIterator.new Nested(nestedIntegers1));
        nestedIntegers.add(flattenNestedListIterator.new Nested(2));
        nestedIntegers.add(flattenNestedListIterator.new Nested(nestedIntegers2));

        NestedIterator nestedIterator = flattenNestedListIterator.new NestedIterator(nestedIntegers);
        while (nestedIterator.hasNext()) {
            System.out.print(nestedIterator.next() + " ");
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class Nested implements NestedInteger {
        Object object;
        public Nested(Object object) {
            this.object = object;
        }

        @Override
        public boolean isInteger() {
            return !(object instanceof List);
        }

        @Override
        public Integer getInteger() {
            return (Integer) object;
        }

        @Override
        public List<NestedInteger> getList() {
            return (List<NestedInteger>) object;
        }
    }

    public class NestedIterator implements Iterator<Integer> {
        private List<Integer> vals;
        private Iterator<Integer> iterator;


        public NestedIterator(List<NestedInteger> nestedList) {
            vals = new ArrayList<>();
            dfs(nestedList);
            iterator = vals.iterator();
        }

        private void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    vals.add(nestedInteger.getInteger());
                } else {
                    dfs(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
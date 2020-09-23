## LeetCode面试01.01题 判断字符是否唯一
----
>实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
   
**示例 1**：
```text
输入: s = "leetcode"
输出: false 
```

**示例 2：**
```text
输入: s = "abc"
输出: true
```
**限制：**
1. 0 <= len(s) <= 100
2. 如果你不使用额外的数据结构，会很加分。

### 题目解析
由于ASCII码字符个数为128个，而且题目说了`如果你不使用额外的数据结构，会很加分。`因此可以使用两个64位的long变量来存储是否出现某个字符，二进制位1表示出现过， 0表示未出现过。具体代码如下：
```java
public class DetermineWhetherTheStringIsUnique {

    public boolean isUnique(String astr) {
        long low64 = 0,height64=0;
        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long index = 1L << (c - 64);
                if ((height64 & index) != 0) return false;
                height64 |= index;
            } else {
                long index = 1L << c;
                if ((low64 & index) != 0) return false;
                low64 |= index;
            }

        }
        return true;
    }

    public static void main(String args[]) {
        String s = "abbc";
        System.out.println(new DetermineWhetherTheStringIsUnique().isUnique(s));
    }
}
```

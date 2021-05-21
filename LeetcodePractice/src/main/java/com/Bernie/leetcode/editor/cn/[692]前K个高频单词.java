//给一非空的单词列表，返回前 k 个出现次数最多的单词。
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表 
// 👍 265 👎 0


package com.Bernie.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

class TopKFrequentWords {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentWords().new Solution();
        System.out.println(solution.topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            List<String> res = new ArrayList<>();
            Map<String, Integer> map = new LinkedHashMap<>();
            for (String word : words) {
                // 讲前K个加入Map
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            map.entrySet()
                    .stream()
                    .sorted((p1, p2) -> {
                        if (p1.getValue() == p2.getValue())
                            return p1.getKey().compareTo(p2.getKey());
                        else
                            return p2.getValue().compareTo(p1.getValue());
                    })
                    .collect(Collectors.toList())
                    .forEach(el -> res.add(el.getKey()));

            return res.subList(0,k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
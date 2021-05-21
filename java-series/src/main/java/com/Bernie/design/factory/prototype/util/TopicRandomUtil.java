package com.Bernie.design.factory.prototype.util;

import java.util.*;

/**
 * @Author Bernie
 * @Date 2020/12/23/023 18:03
 */
public class TopicRandomUtil {
    /**
     * 乱序Map元素，记录对应答案
     *
     * @param option 题目
     * @param key    答案
     * @return Topic
     */
    static public Topic random(Map<String, String> option, String key) {
        Set<String> keySet = option.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        Collections.shuffle(keyList);
        Map<String, String> newOption = new HashMap<>();
        String newKey = "";
        int idx = 0;
        for (String next : keySet) {
            String randomKey = keyList.get(idx++);
            if (next.equals(key)) {
                newKey = randomKey;
            }
            newOption.put(randomKey,option.get(next));
        }
        return new Topic(newOption, newKey);
    }

}

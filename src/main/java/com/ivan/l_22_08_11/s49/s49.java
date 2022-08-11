package com.ivan.l_22_08_11.s49;

import java.util.*;

/**
 * @author Maximilian_Li
 */
public class s49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            char[] example = str.toCharArray();
            Arrays.sort(example);
            String pattern = Arrays.toString(example);

            if (!map.containsKey(pattern)) {
                // 映射中不包含
                map.put(pattern, new ArrayList<>());
            }

            // 无论如何都要讲这个字符串加到map中
            map.get(pattern).add(str);
        }

        Set<String> strings = map.keySet();
        for (String s : strings) {
            result.add(map.get(s));
        }

        return result;
    }
}

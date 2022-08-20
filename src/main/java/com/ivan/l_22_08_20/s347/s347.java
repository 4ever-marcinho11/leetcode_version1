package com.ivan.l_22_08_20.s347;

import java.util.*;

public class s347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        System.out.println(map);

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> item : set) {
            queue.offer(item);
        }

        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(queue.poll()).getKey();
        }

        System.out.println(queue);

        return res;
    }
}

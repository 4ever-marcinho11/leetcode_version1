package com.ivan.l_22_09_06.s78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s78 {
    private final List<List<Integer>> res = new ArrayList<>();
    private final LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            res.add(new ArrayList<>());
        } else {
            bt(nums, 0);
        }
        return res;
    }

    public void bt(int[] nums, int start) {
        // 因为要遍历整棵树，因此不需要添加if，因为if是将叶子节点加入res的
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            bt(nums, i + 1);
            path.removeLast();
        }
    }
}

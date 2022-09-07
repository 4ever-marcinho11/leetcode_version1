package com.ivan.l_22_09_07.s491;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s491 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
     * <p>
     * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况
     *
     * @param nums 数组
     * @return 递增子序列
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        bt(nums, 0);
        return res;
    }

    public void bt(int[] nums, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }

        // 由于不能排序，因此使用hash map来记录同层是否有相同元素
        HashMap<Integer, Integer> used = new HashMap<>();
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast()) {
                // 新要加入的元素不能更小
                continue;
            }

            if (used.getOrDefault(nums[i], 0) > 1) {
                // 同层有相同元素
                continue;
            }

            path.add(nums[i]);
            used.put(nums[i], used.getOrDefault(nums[i], 0) + 1);
            bt(nums, i + 1);
            path.removeLast();
            used.put(nums[i], used.get(nums[i]) - 1);
        }
    }
}

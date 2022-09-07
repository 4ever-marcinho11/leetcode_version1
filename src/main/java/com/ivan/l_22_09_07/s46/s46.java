package com.ivan.l_22_09_07.s46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class s46 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     * @param nums 数组
     * @return 全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }

        int[] used = new int[nums.length];
        Arrays.fill(used, 0);
        bt(nums, used);
        return res;
    }

    /**
     * 排列问题不能用start，只需要used
     *
     * @param nums 数组
     * @param used 是否使用数组，0为未使用
     */
    public void bt(int[] nums, int[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 0) {
                path.add(nums[i]);
                used[i] = 1;
                bt(nums, used);
                path.removeLast();
                used[i] = 0;
            }
        }
    }
}

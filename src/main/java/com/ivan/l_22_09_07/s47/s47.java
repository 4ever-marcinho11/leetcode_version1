package com.ivan.l_22_09_07.s47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s47 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     * @param nums 序列
     * @return 全排列
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] u1 = new int[nums.length];
        int[] u2 = new int[nums.length];
        Arrays.fill(u1, 0);
        Arrays.fill(u2, 0);
        bt(nums, u1, u2);
        return res;
    }

    /**
     * @param nums  数组
     * @param used1 判断当前数字能否使用
     * @param used2 判断同层是否有相同数字未使用
     */
    public void bt(int[] nums, int[] used1, int[] used2) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used1[i] == 0) {
                // 当前数字能使用
                if (i > 0 && nums[i] == nums[i - 1] && used2[i - 1] == 0) {
                    // 当前数字别使用了
                    continue;
                }
                path.add(nums[i]);
                used1[i] = 1;
                used2[i] = 1;
                bt(nums, used1, used2);
                path.removeLast();
                used1[i] = 0;
                used2[i] = 0;
            }
        }
    }
}

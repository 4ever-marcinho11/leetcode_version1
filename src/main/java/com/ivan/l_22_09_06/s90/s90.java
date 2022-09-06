package com.ivan.l_22_09_06.s90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s90 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        Arrays.fill(used, 0);
        bt(nums, 0, used);
        return res;
    }

    public void bt(int[] nums, int start, int[] used) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            bt(nums, i + 1, used);
            path.removeLast();
            used[i] = 0;
        }
    }
}

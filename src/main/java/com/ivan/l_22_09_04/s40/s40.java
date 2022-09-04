package com.ivan.l_22_09_04.s40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s40 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] used = new int[candidates.length];
        Arrays.fill(used, 0);
        bt(0, candidates, 0, target, used);
        return res;
    }

    public void bt(int start, int[] candidates, int current, int target, int[] used) {
        if (current > target) {
            return;
        }
        if (current == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length && current + candidates[i] <= target; i++) {
            // 对同一层使用过的元素进行跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) {
                continue;
            }
            // do
            path.add(candidates[i]);
            current += candidates[i];
            used[i] = 1;
            // bt
            bt(i + 1, candidates, current, target, used);
            // cancel
            path.removeLast();
            current -= candidates[i];
            used[i] = 0;
        }
    }
}

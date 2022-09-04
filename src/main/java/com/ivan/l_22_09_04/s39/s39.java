package com.ivan.l_22_09_04.s39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s39 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(0, candidates, target, 0);
        return res;
    }

    public void bt(int start, int[] candidates, int target, int current) {
        if (current > target) {
            return;
        }

        if (current == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        // current + candidates[i] <= target是为了剪枝，因为如果大于就不必进入这个分支进行回溯
        // 正因为有可能不会进入某个分支，所以在一开始应该给candidates排序
        for (int i = start; i < candidates.length && current + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            current += candidates[i];
            bt(i, candidates, target, current);
            path.removeLast();
            current -= candidates[i];
        }
    }
}

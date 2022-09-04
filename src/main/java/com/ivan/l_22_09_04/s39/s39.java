package com.ivan.l_22_09_04.s39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s39 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            current += candidates[i];
            bt(i, candidates, target, current);
            path.removeLast();
            current -= candidates[i];
        }
    }
}

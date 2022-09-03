package com.ivan.l_22_09_03.s216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s216 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     * 只使用数字1到9
     * 每个数字 最多使用一次
     *
     * @param k size
     * @param n sum
     * @return res
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        bt(0, n, k, 1);
        return res;
    }

    /**
     * backtrack
     *
     * @param current current sum
     * @param target  target sum
     * @param size    maximum volume
     * @param start   start from
     */
    public void bt(int current, int target, int size, int start) {
        if (path.size() == size) {
            if (current == target) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            // do
            path.add(i);
            current += i;
            // bt
            bt(current, target, size, i + 1);
            // cancel
            path.removeLast();
            current -= i;
        }
    }
}

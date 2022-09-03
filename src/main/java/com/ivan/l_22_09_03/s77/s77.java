package com.ivan.l_22_09_03.s77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s77 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     *
     * @param n 上界
     * @param k 小组中的数量
     * @return 所有组合
     */
    public List<List<Integer>> combine(int n, int k) {
        bt(n, k, 1);
        return res;
    }

    /**
     * 回溯模板
     *
     * @param n        上限
     * @param k        最大容量
     * @param startNum 起始数字，也是回溯中的下限
     */
    public void bt(int n, int k, int startNum) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 选择 : 选择列表
        // n - (k - path.size()) + 1表示满足后续添加数字的需求的最小数
        for (int i = startNum; i <= n - (k - path.size()) + 1; i++) {
            // 添加
            path.add(i);
            // 回溯
            bt(n, k, i + 1);
            // 撤销
            path.removeLast();
        }
    }
}

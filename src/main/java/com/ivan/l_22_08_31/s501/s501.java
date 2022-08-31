package com.ivan.l_22_08_31.s501;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Maximilian_Li
 */
public class s501 {
    public int[] findMode(TreeNode root) {
        // 获取二叉搜索树的中序遍历数组
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] arr = list.stream().mapToInt((one) -> one).toArray();

        // 获取众数：值 - 频率
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 找到频率最大值
        ArrayList<Integer> res = new ArrayList<>();
        Integer maxFre = map.values().stream().max(Integer::compare).get();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue().equals(maxFre)) {
                res.add(entry.getKey());
            }
        }

        return res.stream().mapToInt((one) -> one).toArray();
    }

    public void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

package com.ivan.l_22_07_17.s105;

import java.util.HashMap;

public class s105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = preorder.length;

        // 将中序遍历的对应元素-下标建立映射表，方便定位根节点的位置
        for (int i = 0; i < size; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, size - 1, inorder, 0, size - 1, map);
    }

    /**
     * @param pre (部分)前序遍历数组
     * @param pl  起始索引(包括)
     * @param pr  中止索引(包括)
     * @param in  部分中序遍历数组
     * @param il  起始索引(包括)
     * @param ir  中止索引(包括)
     * @param map 中序遍历的映射表
     * @return (子)树的根节点
     */
    public TreeNode build(int[] pre, int pl, int pr, int[] in, int il, int ir, HashMap<Integer, Integer> map) {
        if (pl > pr) {
            return null;
        }

        // 该子树的根节点索引
        int prIdx = pl;

        // 找到中序遍历中的该节点索引
        int irIdx = map.get(pre[prIdx]);

        // 得到该根节点的左子树中节点个数
        int howManyInLeft = irIdx - il;

        // 构造该根节点
        TreeNode root = new TreeNode(pre[pl]);

        // 构造该根节点的左子树(前序：起始的下一个~起始的左子节点个数个，中序：起始~根节点的前一个)
        root.left = build(pre, pl + 1, pl + howManyInLeft, in, il, prIdx - 1, map);

        // 构造该根节点的右子树(前序：起始的左子节点个数个的下一个~中止，中序：根节点的下一个~中止)
        root.right = build(pre, pl + howManyInLeft + 1, pr, in, irIdx + 1, ir, map);

        return root;
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
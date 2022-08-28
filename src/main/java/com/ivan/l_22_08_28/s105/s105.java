package com.ivan.l_22_08_28.s105;

import java.util.HashMap;

/**
 * @author Maximilian_Li
 */
public class s105 {
    /**
     * 根据前序遍历与中序遍历构造二叉树
     *
     * @param preorder 前序遍历数组
     * @param inorder  中序遍历数组
     * @return 构造出的树的根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> mapper = new HashMap<>();

        // 根据前序遍历找相关节点在中序遍历数组中的位置，因此要记录终于便利数组中节点值与索引的对应关系
        int size = inorder.length;
        for (int i = 0; i < size; i++) {
            mapper.put(inorder[i], i);
        }

        return buildInTwoArr(
                preorder, 0, size - 1,
                inorder, 0, size - 1,
                mapper);
    }

    /**
     * 根据两个数组与两个数组的起始与中止索引递归地构造出一颗二叉树
     *
     * @param pre        前序遍历数组
     * @param startOfPre 起始索引
     * @param endOfPre   中止索引
     * @param in         中序遍历数组
     * @param startOfIn  起始索引
     * @param endOfIn    中止索引
     * @param mapper     映射表
     * @return 根节点
     */
    public TreeNode buildInTwoArr(int[] pre,
                                  int startOfPre,
                                  int endOfPre,
                                  int[] in,
                                  int startOfIn,
                                  int endOfIn,
                                  HashMap<Integer, Integer> mapper) {

        if (startOfPre > endOfPre) {
            return null;
        }

        // 根据前序遍历获取根节点索引
        int rootIdxInPre = startOfPre;
        // 找到这个节点在中序遍历数组中的位置
        int locOfRootInIn = mapper.get(pre[rootIdxInPre]);
        // 记录该根节点的左子树的节点数量
        int numInLeft = locOfRootInIn - startOfIn;

        // 构造根节点
        TreeNode root = new TreeNode(pre[rootIdxInPre]);
        // 构造根节点的左子节点与右子节点
        root.left = buildInTwoArr(
                pre, startOfPre + 1, startOfPre + numInLeft,
                in, startOfIn, locOfRootInIn - 1,
                mapper
        );
        root.right = buildInTwoArr(
                pre, startOfPre + numInLeft + 1, endOfPre,
                in, locOfRootInIn + 1, endOfIn,
                mapper
        );

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

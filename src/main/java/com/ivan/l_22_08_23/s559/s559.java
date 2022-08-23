package com.ivan.l_22_08_23.s559;

import java.util.Arrays;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s559 {
    public int maxDepth(Node root) {
        return getHeight(root);
    }

    private int getHeight(Node root) {
        if (root == null) {
            // 空节点
            return 0;
        } else if (root.children.isEmpty()) {
            // 叶子节点
            return 1;
        }

        int[] arr = new int[root.children.size()];
        for (int i = 0; i < root.children.size(); i++) {
            arr[i] = maxDepth(root.children.get(i));
        }

        return Arrays.stream(arr).max().getAsInt() + 1;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

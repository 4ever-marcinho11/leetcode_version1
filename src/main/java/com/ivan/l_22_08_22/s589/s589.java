package com.ivan.l_22_08_22.s589;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s589 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        pre(root);
        return res;
    }

    private Node pre(Node root) {
        if (root == null) {
            return null;
        }

        res.add(root.val);

        for (Node node : root.children) {
            pre(node);
        }

        return root;
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

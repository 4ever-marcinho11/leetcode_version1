package com.ivan.l_22_08_22.s590;


import java.util.ArrayList;
import java.util.List;

public class s590 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        post(root);
        return res;
    }

    private Node post(Node root) {
        if (root == null) {
            return null;
        }

        for (Node node : root.children) {
            post(node);
        }

        res.add(root.val);

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


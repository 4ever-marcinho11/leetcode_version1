package com.ivan.l_22_07_10.s96;

public class s96 {
    public int numTrees(int n) {
        // G(n)=∑(i=1,n)(G(i−1)⋅G(n−i))
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;

        // i是节点总个数
        for (int i = 2; i <= n; i++) {
            // j是当前节点
            for (int j = 1; j <= i; j++) {
                g[i] += g[j - 1] * g[i - j];
            }
        }

        return g[n];
    }
}

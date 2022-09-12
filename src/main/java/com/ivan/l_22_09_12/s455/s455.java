package com.ivan.l_22_09_12.s455;

import java.util.Arrays;

/**
 * @author Maximilian_Li
 */
public class s455 {
    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     * <p>
     * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *
     * @param g 孩子的胃口数组
     * @param s 饼干数组
     * @return 能喂饱几个孩子
     */
    public int findContentChildren(int[] g, int[] s) {
        // 使用贪心算法，用大的喂饱大的
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;

        int biscuits = s.length - 1;
        int children = g.length - 1;
        for (int i = children; i >= 0; i--) {
            if (biscuits >= 0 && s[biscuits] >= g[i]) {
                // 用大块的饼干喂饱大胃口的孩子
                res++;
                biscuits--;
            }
        }

        return res;
    }
}

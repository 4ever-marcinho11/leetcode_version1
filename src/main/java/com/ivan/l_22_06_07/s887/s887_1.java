package com.ivan.l_22_06_07.s887;

public class s887_1 {

    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    public int dp(int k, int n) {
        // 找到使鸡蛋不碎的最高楼层时，扔的最少次数
        int res = Integer.MAX_VALUE;

        if (k == 1) {
            // 最坏情况就是搜索空间穷尽的时候
            return n;
        }
        if (n == 0) {
            return 0;
        }

        for (int i = 1; i <= n; i++) {
            res = Integer.min(
                    res,
                    // +1代表在第i层操作了一次
                    Integer.max(
                            // 碎了，鸡蛋少一个，往下找
                            dp(k - 1, i - 1),
                            // 没碎，鸡蛋没少，往上找
                            dp(k, n - i)) + 1
            );
        }
        return res;
    }
}

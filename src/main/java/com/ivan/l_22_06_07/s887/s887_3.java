package com.ivan.l_22_06_07.s887;

public class s887_3 {
    public int superEggDrop(int k, int n) {
        // dp[几个][第几次恰好不碎]=最坏情况下测试楼层数
        int[][] dp = new int[k + 1][n + 1];

        // base case

        // cases and choices
        int times = 0;
        while (dp[k][times] < n) {
            // 0层无意义，跳过
            times++;
            for (int num = 1; num <= k; num++) {
                // 总楼层数 = 下面有几层（碎了的话可以得到） + 上面有几层（没碎的话可以得到） + 1（本层）
                dp[num][times] = dp[num][times - 1] + dp[num - 1][times - 1] + 1;
                System.out.println("给你" + num + "个鸡蛋，如果最坏情况下最少测试" + times + "次，那么最坏情况下能测试" + dp[num][times] + "层楼");
            }
        }

        return times;
    }

}

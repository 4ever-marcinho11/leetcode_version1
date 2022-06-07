package com.ivan.l_22_06_07.s887;

public class s887_2 {
    public int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    public int dp(int k, int n) {
        int res = Integer.MAX_VALUE;

        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }

        // 使用二分搜索来替换线性搜索
        int left = 1, right = n;
        while (left <= right) {
            // 在mid层
            int mid = left + (right - left) / 2;

            // 在mid层碎、没碎的值
            int broken = dp(k - 1, mid - 1);
            int notBroken = dp(k, n - mid);

            if (broken > notBroken) {
                right = mid - 1;
                res = Integer.min(res, broken + 1);
            } else {
                left = mid + 1;
                res = Integer.min(res, notBroken + 1);
            }
        }

        return res;
    }
}

package com.ivan.l_22_08_09.s59;

/**
 * @author Maximilian_Li
 */
public class s59 {
    public int[][] generateMatrix(int n) {
        // 第几圈，控制循环次数
        int loop = 0;
        int[][] res = new int[n][n];
        // 每次循环的开始点(start, start)
        int start = 0;
        // 定义填充数字
        int count = 1;
        int x, y;

        // 判断边界后，loop从1开始
        while (loop++ < n / 2) {
            // 模拟上侧从左到右
            for (y = start; y < n - loop; y++) {
                res[start][y] = count++;
            }

            // 模拟右侧从上到下
            for (x = start; x < n - loop; x++) {
                res[x][y] = count++;
            }

            // 模拟下侧从右到左
            for (; y >= loop; y--) {
                res[x][y] = count++;
            }

            // 模拟左侧从下到上
            for (; x >= loop; x--) {
                res[x][y] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }
}

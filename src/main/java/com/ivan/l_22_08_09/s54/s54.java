package com.ivan.l_22_08_09.s54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maximilian_Li
 */
public class s54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int loop = 0;
        int x = 0, y = 0;
        int start = 0;

        // 因为rows不一定等于cols，所以需要定义这两个变量
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 排除简单情况
        if (rows == 1) {
            for (int i : matrix[0]) {
                res.add(i);
            }
            return res;
        } else if (cols == 1) {
            for (int[] ints : matrix) {
                res.add(ints[0]);
            }
            return res;
        }

        while (loop++ < Math.min(rows, cols) / 2) {
            for (y = start; y < cols - loop; y++) {
                res.add(matrix[start][y]);
            }

            for (x = start; x < rows - loop; x++) {
                res.add(matrix[x][y]);
            }

            for (; y >= loop; y--) {
                res.add(matrix[x][y]);
            }

            for (; x >= loop; x--) {
                res.add(matrix[x][y]);
            }

            start++;
        }

        if (rows == cols && rows % 2 == 1) {
            // 奇数n*n矩阵，把中间的补齐
            res.add(matrix[start][start]);
        } else if (rows != cols) {
            // 非n*n矩阵，短边必须为奇数且大于2
            if (rows > cols && cols > 2 && cols % 2 == 1) {
                for (int i = start; i < rows - 1; i++) {
                    res.add(matrix[i][start]);
                }
            } else if (cols > rows && rows > 2 && rows % 2 == 1) {
                for (int i = start; i < cols - start; i++) {
                    res.add(matrix[start][i]);
                }
            }
        }

        return res;
    }
}

package com.ivan.l_22_09_16.s134;

import java.util.Arrays;

/**
 * @author Maximilian_Li
 */
public class s134 {
    /**
     * 在一条环路上有 n个加油站，其中第 i个加油站有汽油gas[i]升。
     * <p>
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。你从其中的一个加油站出发，开始时油箱为空。
     * <p>
     * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
     *
     * @param gas  加油站数组
     * @param cost 油耗数组
     * @return 起始加油站编号或-1
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int finalStart = 0;

        // 加的油总和小于消耗的总和，肯定不能绕场一周
        int canCycle = Arrays.stream(gas).sum() - Arrays.stream(cost).sum();
        if (canCycle < 0) {
            return -1;
        }

        // 以下说明一定能成环
        // 只要当前的油余量为负，就说明不能从当前出发。应该从后面重新算起
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                finalStart = i + 1;
                sum = 0;
            }
        }
        return finalStart;
    }
}

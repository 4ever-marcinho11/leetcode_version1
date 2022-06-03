package com.ivan.l_22_06_03.s322;

import junit.framework.TestCase;

public class s322Test extends TestCase {
    private s322 s322 = new s322();

    public void test() {
        int[] coins = new int[]{1};
        int amount = 0;
        int res = s322.coinChange(coins, amount);
        System.out.println("res = " + res);
    }
}
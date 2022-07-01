package com.ivan.l_22_06_30.s1011;

import junit.framework.TestCase;

public class s1011Test extends TestCase {
    private s1011 s = new s1011();

    public void test() {
        int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 10;

        System.out.println("s.shipWithinDays(weights, days) = " + s.shipWithinDays(weights, days));
    }
}
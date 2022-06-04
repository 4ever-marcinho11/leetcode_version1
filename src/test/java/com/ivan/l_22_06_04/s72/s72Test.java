package com.ivan.l_22_06_04.s72;

import junit.framework.TestCase;

public class s72Test extends TestCase {
    private s72 s72 = new s72();

    public void test() {
        String w1 = "horse";
        String w2 = "ros";
        int res = s72.minDistance(w1, w2);
        System.out.println("res = " + res);
    }
}
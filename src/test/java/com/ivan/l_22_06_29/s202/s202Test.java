package com.ivan.l_22_06_29.s202;

import junit.framework.TestCase;

public class s202Test extends TestCase {
    private s202 s = new s202();

    public void test() {
        System.out.println("s.isHappy(19) = " + s.isHappy(19));
        System.out.println("s.isHappy(82) = " + s.isHappy(82));
        System.out.println("s.isHappy(11) = " + s.isHappy(11));
        System.out.println("s.isHappy(102) = " + s.isHappy(102));
    }
}
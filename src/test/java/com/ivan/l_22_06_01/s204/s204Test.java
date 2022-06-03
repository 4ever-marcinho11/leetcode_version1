package com.ivan.l_22_06_01.s204;

import junit.framework.TestCase;

public class s204Test extends TestCase {
    private s204 s204 = new s204();

    public void test() {
        int count = s204.countPrimes(17);
        System.out.println("count = " + count);
    }
}
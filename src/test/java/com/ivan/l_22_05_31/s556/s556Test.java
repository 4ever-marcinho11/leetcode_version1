package com.ivan.l_22_05_31.s556;

import junit.framework.TestCase;

public class s556Test extends TestCase {
    private s556 s556 = new s556();

    public void test() {
        int res = s556.nextGreaterElement(1999999999);
        System.out.println("res = " + res);
    }
}
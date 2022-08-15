package com.ivan.l_22_08_15.s541;

import junit.framework.TestCase;
import org.junit.Test;

public class s541Test extends TestCase {
    private final s541 solution = new s541();

    @Test
    public void test() {
        String str = "abcdef";
        System.out.println("str = " + str);
        int k = 2;
        String result = solution.reverseStr(str, k);
        System.out.println("result = " + result);
    }
}
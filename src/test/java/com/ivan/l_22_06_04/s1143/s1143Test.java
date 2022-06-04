package com.ivan.l_22_06_04.s1143;

import junit.framework.TestCase;

public class s1143Test extends TestCase {
    private s1143 s1143 = new s1143();

    public void test() {
        String t1 = "aceb";
        String t2 = "pppp";
        int res = s1143.longestCommonSubsequence(t1, t2);
        System.out.println("res = " + res);
    }
}
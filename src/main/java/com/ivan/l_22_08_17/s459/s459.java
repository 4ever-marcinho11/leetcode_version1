package com.ivan.l_22_08_17.s459;

/**
 * @author Maximilian_Li
 */
public class s459 {
    /**
     * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成
     *
     * @param s 字符串
     * @return 是否
     */
    public boolean repeatedSubstringPattern(String s) {
        // 一个字符串能由两个子串拼成的话，就证明两个字符串中能找到一个字符串
        if (s.length() == 1) {
            return false;
        }

        String twice = s + s;
        System.out.println(twice);
        twice = twice.substring(1, twice.length() - 1);
        return twice.contains(s);
    }
}

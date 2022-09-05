package com.ivan.l_22_09_05.s93;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效的IP地址正好由四个整数（每个整数位于0到255之间组成，且不能含有前导 0）
 * 整数之间用 '.' 分隔。
 *
 * @author Maximilian_Li
 */
public class s93 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return res;
        }
        bt(0, s, 0);
        return res;
    }

    public void bt(int start, String s, int pointNum) {
        if (pointNum == 3) {
            // 如果第四段合法，就放入path中
            if (isValid(s, start, s.length() - 1)) {
                res.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isValid(s, start, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
            } else {
                continue;
            }
            bt(i + 2, s, pointNum);
            s = s.substring(0, i + 1) + s.substring(i + 2);
            pointNum--;
        }
    }

    public boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }

        if (s.charAt(start) == '0' && start != end) {
            // 非0数字不能以0开头
            return false;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                // 不能包含非数字与.的字符
                return false;
            }
            sum = sum * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            if (sum > 255) {
                // 一段字符一定在0-255的范围内
                return false;
            }
        }
        return true;
    }
}

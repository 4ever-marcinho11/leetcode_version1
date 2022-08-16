package com.ivan.l_22_08_16.o05;

/**
 * @author Maximilian_Li
 */
public class o5 {
    public String replaceSpace(String s) {
        String blank = " ";
        String alternative = "%20";
        StringBuilder b = new StringBuilder();

        if (s.contains(blank)) {
            // 包含空格
            String[] t = s.split("");
            for (String ele : t) {
                if (ele.equals(blank)) {
                    ele = alternative;
                }
                b.append(ele);
            }

            s = b.toString();
        }

        return s;
    }
}

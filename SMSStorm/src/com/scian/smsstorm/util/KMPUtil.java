package com.scian.smsstorm.util;

public final class KMPUtil {

    /**
     * 获得字符串的next函数值
     * 
     * @param t
     *            字符串
     * @return next函数值
     */
    private static int[] next(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < t.length - 1) {
            if (j == -1 || t[i] == t[j]) {
                i++;
                j++;
                if (t[i] != t[j]) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                j = next[j];
            }
        }
        return next;
    }

    /**
     * KMP匹配字符串
     * 
     * @param s
     *            主串
     * @param t
     *            模式串
     * @return 若匹配成功，返回下标，否则返回-1
     */
    public static int indexOf(char[] s, char[] t) {
        int[] next = next(t);
        int i = 0;
        int j = 0;
        while (i <= s.length - 1 && j <= t.length - 1) {
            if (j == -1 || s[i] == t[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j < t.length) {
            return -1;
        } else
            return i - t.length; // 返回模式串在主串中的头下标
    }

    public static int indexOf(String source, String pattern) {
        char[] sourceArray = source.toCharArray();
        char[] patternArray = pattern.toCharArray();
        int source_length = sourceArray.length;
        int pattern_length = patternArray.length;
        if (source_length < pattern_length) {
            return -1;
        } else {
            return indexOf(sourceArray, patternArray);
        }
    }

}

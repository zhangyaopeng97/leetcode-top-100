package com.zhangyaopeng97.practice.top1_10;

import java.util.Arrays;

/**
 * 3. 无重复字符的最长子串
 *  给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 * @since 2025/04/15 17:15
 * @see <a href="题目来源">https://leetcode.cn/problems/longest-substring-without-repeating-characters</a>
 * @author zyp
 */
public class practice1 {
    public static int calMaxCharLength(String str) {
        if (str == null || str.isEmpty()) return 0;

        int[] lastIndex = new int[128]; // ASCII字符集覆盖所有用例
        Arrays.fill(lastIndex, -1);
        int left = 0, max = 0;

        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);
            // 若字符已存在且其上次出现位置在窗口内，则跳跃左指针
            if (lastIndex[c] >= left) {
                left = lastIndex[c] + 1;
            }
            lastIndex[c] = right; // 更新字符最后出现位置
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "teuqwgyiqgduqdiuwqdwqhdoihwqdouwqhduwqodwqdq";
        System.out.println(calMaxCharLength(str));
    }
}

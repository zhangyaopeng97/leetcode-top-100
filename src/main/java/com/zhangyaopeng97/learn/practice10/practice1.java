package com.zhangyaopeng97.learn.practice10;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * 中等
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class practice1 {

    public static void main(String[] args) {
        String str = "teuqwgyiqgduqdiuwqdwqhdoihwqdouwqhduwqodwqdq";
        System.out.println(calMaxCharLength(str));
        System.out.println(calMaxChar(str));
    }

    /**
     * 返回最大不连续字符串长度
     */
    private static int calMaxCharLength(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        List<Character> charArr = new LinkedList<>();
        int index = 0, max = 1;
        while (index < str.length()) {
            if (!charArr.contains(str.charAt(index))) {
                charArr.add(str.charAt(index));
                max = Math.max(max, charArr.size());
                index++;
            } else {
                charArr.remove(0);
            }
        }
        return max;
    }

    /**
     * 拓展：返回最大不连续字符串
     */
    private static List<String> calMaxChar(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.length() == 1) {
            return Collections.singletonList(str);
        }
        List<String> stringList = new LinkedList<>();
        List<Character> charArr = new LinkedList<>();
        int indexLeft = 0, indexRight = 1, max = 1;
        charArr.add(str.charAt(indexLeft));
        while (indexRight < str.length()) {
            if (!charArr.contains(str.charAt(indexRight))) {
                charArr.add(str.charAt(indexRight));
                max = Math.max(max, charArr.size());
                stringList = putMaxStr(stringList, charArr);
                indexRight++;
            } else {
                charArr.remove(0);
                indexLeft++;
            }
        }
        return stringList;
    }

    private static List<String> putMaxStr(List<String> stringList, List<Character> charList) {
        String charStr = charList.stream().map(String::valueOf).collect(Collectors.joining());
        if (stringList == null || stringList.isEmpty()) {
            LinkedList<String> strings = new LinkedList<>();
            strings.add(charStr);
            return strings;
        }
        if (stringList.contains(charStr)) {
            return stringList;
        }
        Integer maxLength = stringList.stream().map(String::length).max(Integer::compareTo).get();
        if (maxLength > charList.size()) {
            return stringList;
        }
        LinkedList<String> strings = new LinkedList<>();
        strings.add(charStr);
        return strings;
    }
}

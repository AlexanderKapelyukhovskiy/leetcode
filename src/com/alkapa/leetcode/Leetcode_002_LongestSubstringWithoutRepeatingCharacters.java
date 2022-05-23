package com.alkapa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_002_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int max = 0;

        for (int i = 0; i < s.length(); ++i) {
            for (int j = i + 1; j < s.length(); ++j) {
                String s1 = s.substring(i, j);

                int pos = s1.indexOf(s.charAt(j));

                if (pos < 0 && j == s.length() - 1) {
                    max = Math.max(max, j - i + 1);
                }


                if (pos >= 0) {
                    max = Math.max(max, j - i);
                    //i = j - 1;
                    break;
                }
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstringV2(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int max = 0;


        for (int i = 0; i < s.length(); ++i) {
            Map<Integer, Boolean> map = new HashMap();

            for (int j = i; j < s.length(); ++j) {
                Boolean exists = map.get((int) s.charAt(j));
                if (exists != null) {
                    max = Math.max(max, j - i);
                    break;
                } else {
                    map.put((int) s.charAt(j), true);
                }
                if (j == s.length() - 1) {
                    return Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstringV3(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        int max = 0;
        Map<Character, Integer> map = new HashMap();

        for (int i = 0, j = 0; i < s.length(); ++i) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                j = Math.max(j, map.get(ch) + 1);
            }
            map.put(ch, i);
            max = Math.max(max, i - j + 1);
        }

        return max;
    }

    public static void test(String s) {
        int t1 = lengthOfLongestSubstringV3(s);
        System.out.println(String.format("%s -> %d", s, t1));
    }

    public static void main(String[] args) {
        test("abcabcbb");
        test("bbbbb");
        test("pwwkew");
        test(" ");
        test("au");
        test("dvdf");
    }
}

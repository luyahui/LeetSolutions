package com.lu;

public class Leet3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        // dp[i] means the longest substring without repeating characters, which ends with s[i]
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int result = 1;

        for (int i = 1; i < dp.length; i++) {
            int length = 1;
            for (int j = i - 1; j > i - 1 - dp[i - 1]; j--) {
                if (s.charAt(j) == s.charAt(i))
                    break;
                length++;
            }
            dp[i] = length;
            result = length > result ? length : result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                new Leet3().lengthOfLongestSubstring("pwwkew"));
    }
}

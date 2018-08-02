package com.lu;

public class Leet5 {

    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        String result = "";

        // dp[i][j] means whether s[i,j] is a palindrome
        boolean[][] dp = new boolean[s.length()][s.length()];

        // construct the dp table
        for (int length = 1; length <= s.length(); length++) {
            for (int i = 0; i < s.length() - length + 1; i++) {
                if (length == 1) {
                    dp[i][i] = true;
                    continue;
                }
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (length == 2)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }

        for (int length = s.length(); length >= 1; length--) {
            for (int i = 0; i < s.length() - length + 1; i++) {
                int j = i + length - 1;
                if (dp[i][j])
                    return s.substring(i, j+1);
            }
        }

        return result;
    }

    public static void main(String[] args){
        Leet5 l5 = new Leet5();
        System.out.println(l5.longestPalindrome("babad"));
    }
}

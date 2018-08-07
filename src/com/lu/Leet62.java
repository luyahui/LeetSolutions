package com.lu;

public class Leet62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                int fromLeft = j - 1 >= 0 ? dp[i][j - 1] : 0;
                int fromUp = i - 1 >= 0 ? dp[i - 1][j] : 0;
                dp[i][j] = fromLeft + fromUp;
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Leet62().uniquePaths(7, 3));
    }
}

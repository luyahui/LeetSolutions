package com.lu;

public class Leet329 {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int[][] dp1 = new int[matrix.length][matrix[0].length];
        int[][] dp2 = new int[matrix.length][matrix[0].length];
        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp1[i][j] = 1;
                dp2[i][j] = 1;
                if(i != 0 || j != 0){
                    int cur = matrix[i][j];
                    if(i != 0){
                        int up = matrix[i-1][j];
                        if(cur > up)
                            dp1[i][j] = Math.max(dp1[i][j], dp1[i-1][j]+1);
                        if(cur < up)
                            dp2[i][j] = Math.max(dp2[i][j], dp2[i-1][j]+1);
                    }
                    if(j != 0){
                        int left = matrix[i][j-1];
                        if(cur > left)
                            dp1[i][j] = Math.max(dp1[i][j], dp1[i][j-1]+1);
                        if(cur < left)
                            dp2[i][j] = Math.max(dp2[i][j], dp2[i][j-1]+1);
                    }
                }
                result = Math.max(result, Math.max(dp1[i][j], dp2[i][j]));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Leet329 l329 = new Leet329();
        System.out.println(l329.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }
}

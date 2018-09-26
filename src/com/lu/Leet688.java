package com.lu;

class Leet688Helper {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] directions = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        double[][] dp = new double[N][N];

        // if the knight doese not move, the probability of remaining on the board is 1, no matter where he is initially
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                dp[i][j] = 1;
        }

        for(int k = 1; k <= K; k++){
            // for kth loop, dpNew[i][j] means the probability of remaining on the board,
            // if the knight starts at [i][j], and he needs to made k moves
            double[][] dpNew = new double[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    for(int[] direction : directions){
                        if(i+direction[0] < 0 || i+direction[0] >= N || j + direction[1] < 0 || j+direction[1] >= N)
                            continue;
                        dpNew[i][j] += dp[i+direction[0]][j+direction[1]] / 8.0;
                    }
                }
            }
            dp = dpNew;
        }

        return dp[r][c];
    }
}

public class Leet688 {
    public static void main(String[] args){
        Leet688Helper helper = new Leet688Helper();
        System.out.println(helper.knightProbability(10, 13, 5, 3));
    }
}

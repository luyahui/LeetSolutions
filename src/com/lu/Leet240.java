package com.lu;

public class Leet240 {
    static class Solution {
        private boolean searchHelper(int[][] matrix, int lr, int lc, int hr, int hc, int target) {
            if (lr < 0 || lc < 0 || lr >= matrix.length || lc >= matrix[0].length)
                return false;
            if (hr < 0 || hc < 0 || hr >= matrix.length || hc >= matrix[0].length)
                return false;
            if (matrix[lr][lc] > target || matrix[hr][hc] < target)
                return false;
            if (lr == hr && lc == hc)
                return matrix[lr][lc] == target;

            int mr = lr + (hr - lr) / 2, mc = lc + (hc - lc) / 2;
            if (matrix[mr][mc] == target)
                return true;
            if (matrix[mr][mc] > target && searchHelper(matrix, lr, lc, mr, mc, target))
                return true;
            if (searchHelper(matrix, mr + 1, lc, hr, mc, target))
                return true;
            if (searchHelper(matrix, lr, mc + 1, mr, hc, target))
                return true;
            if (searchHelper(matrix, mr + 1, mc + 1, hr, hc, target))
                return true;
            return false;
        }

        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0)
                return false;

            int lr = 0, lc = 0, hr = matrix.length - 1, hc = matrix[0].length - 1;
            return searchHelper(matrix, lr, lc, hr, hc, target);
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};

        System.out.println(new Solution().searchMatrix(matrix, 5));
    }
}

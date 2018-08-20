package com.lu;

public class Leet378 {
    public int kthSmallest(int[][] matrix, int k) {
        int[] pos = new int[matrix.length];

        int count = 0, num = -1;
        while (count < k) {
            int x = 0;
            for (; x < matrix.length; x++) {
                if (pos[x] < matrix[x].length)
                    break;
            }
            num = matrix[x][pos[x]];
            int ind = x;
            for (; x < matrix.length; x++) {
                if (matrix[x][pos[x]] < num) {
                    num = matrix[x][pos[x]];
                    ind = x;
                }
            }
            pos[ind]++;
            count++;
        }

        return num;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        Leet378 l378 = new Leet378();
        System.out.println(l378.kthSmallest(nums, 8));
    }
}

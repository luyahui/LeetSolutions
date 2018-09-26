package com.lu;

public class Leet329 {
    private int search(int[][] matrix, int[][] memory, int x, int y) {
        if(memory[x][y] > 0)
            return memory[x][y];
        int result = 1;
        // head left
        if (y - 1 >= 0 && matrix[x][y] > matrix[x][y - 1]) {
            result = Math.max(result, 1 + search(matrix, memory, x, y - 1));
        }
        // head right
        if (y + 1 < matrix[0].length && matrix[x][y] > matrix[x][y + 1]) {
            result = Math.max(result, 1 + search(matrix, memory, x, y + 1));
        }
        // head up
        if (x - 1 >= 0 && matrix[x][y] > matrix[x - 1][y]) {
            result = Math.max(result, 1 + search(matrix, memory,x - 1, y));
        }
        // head down
        if (x + 1 < matrix.length && matrix[x][y] > matrix[x + 1][y]) {
            result = Math.max(result, 1 + search(matrix, memory,x + 1, y));
        }

        memory[x][y] = result;
        return result;
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int result = 0;
        int[][] memory = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result = Math.max(result, search(matrix, memory, i, j));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Leet329 l329 = new Leet329();
        System.out.println(l329.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }
}

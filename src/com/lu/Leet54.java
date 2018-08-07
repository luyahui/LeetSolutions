package com.lu;

import java.util.ArrayList;
import java.util.List;

public class Leet54 {
    boolean isValid(boolean[][] flag, int x, int y) {
        if (x < 0 || x >= flag.length)
            return false;
        if (y < 0 || y >= flag[0].length)
            return false;
        return flag[x][y] == false;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int total = matrix.length * matrix[0].length;
        int direction = 0, x = 0, y = -1;
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];

        while (true) {
            if(result.size() == total)
                break;
            direction %= 4;

            if (direction == 0) {
                y++;
                if (isValid(flag, x, y)) {
                    result.add(matrix[x][y]);
                    flag[x][y] = true;
                } else {
                    y--;
                    direction++;
                }
            } else if (direction == 1) {
                x++;
                if (isValid(flag, x, y)) {
                    result.add(matrix[x][y]);
                    flag[x][y] = true;
                } else {
                    x--;
                    direction++;
                }
            } else if (direction == 2) {
                y--;
                if (isValid(flag, x, y)) {
                    result.add(matrix[x][y]);
                    flag[x][y] = true;
                } else {
                    y++;
                    direction++;
                }
            } else {
                x--;
                if (isValid(flag, x, y)) {
                    result.add(matrix[x][y]);
                    flag[x][y] = true;
                } else {
                    x++;
                    direction++;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {4, 5, 6, 8},
                {7, 8, 9, 0}
        };

        System.out.println(new Leet54().spiralOrder(matrix));
    }

}

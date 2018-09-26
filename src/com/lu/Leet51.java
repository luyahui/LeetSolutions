package com.lu;

import java.util.ArrayList;
import java.util.List;

public class Leet51 {
    private boolean isPlaceble(List<String> board, int pos) {

        for (int i = 0; i < board.size(); i++) {
            String string = board.get(i);
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) != 'Q')
                    continue;
                if (j == pos)
                    return false;
                if (board.size() - i == Math.abs(pos - j))
                    return false;

            }
        }
        return true;
    }

    private void backtrack(int current, int total, List<String> board, List<List<String>> result) {
        if (current >= total) {
            result.add(new ArrayList(board));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++)
            sb.append('.');

        for (int i = 0; i < total; i++) {
            if (isPlaceble(board, i)) {
                sb.setCharAt(i, 'Q');
                board.add(sb.toString());
                backtrack(current + 1, total, board, result);
                board.remove(board.size() - 1);
                sb.setCharAt(i, '.');
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> board = new ArrayList<>();

        backtrack(0, n, board, result);
        return result;
    }

    public static void main(String[] args) {
        Leet51 l51 = new Leet51();
        System.out.println(l51.solveNQueens(3));
    }
}



package com.lu;

public class Leet289 {
    private int getLiveNeighbors(int[][] board, int x, int y){
        int result = 0;
        for(int i = Math.max(0, x-1); i <= Math.min(x+1, board.length-1); i++){
            for(int j = Math.max(0, y-1); j <= Math.min(y+1, board[0].length-1); j++){
                if(i == x && j == y)
                    continue;
                if(board[i][j]%2 == 1)
                    result++;
            }
        }
        return result;
    }

    public void gameOfLife(int[][] board) {
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                int liveNeighbors = getLiveNeighbors(board, x, y);
                if(board[x][y] == 1 && (liveNeighbors == 2 || liveNeighbors == 3))
                    board[x][y] = 3;
                else if(board[x][y] == 0 && liveNeighbors == 3)
                    board[x][y] = 2;
            }
        }

        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                board[x][y] /= 2;
            }
        }
    }

    public static void main(String[] args){
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        Leet289 l289 = new Leet289();
        l289.gameOfLife(board);
        System.out.println(board);
    }
}

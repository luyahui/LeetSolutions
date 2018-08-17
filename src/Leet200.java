import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leet200 {
    private void search(int x, int y, char[][] grid, boolean[][] visited) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{x, y});
        while (stack.size() > 0) {
            int[] arr = stack.pop();
            visited[arr[0]][arr[1]] = true;
            if (arr[0] - 1 >= 0 && !visited[arr[0] - 1][arr[1]] && grid[arr[0] - 1][arr[1]] == '1')
                stack.add(new int[]{arr[0] - 1, arr[1]});
            if (arr[0] + 1 < grid.length && !visited[arr[0] + 1][arr[1]] && grid[arr[0] + 1][arr[1]] == '1')
                stack.add(new int[]{arr[0] + 1, arr[1]});
            if (arr[1] - 1 >= 0 && !visited[arr[0]][arr[1] - 1] && grid[arr[0]][arr[1] - 1] == '1')
                stack.add(new int[]{arr[0], arr[1] - 1});
            if (arr[1] + 1 < grid[0].length && !visited[arr[0]][arr[1] + 1] && grid[arr[0]][arr[1] + 1] == '1')
                stack.add(new int[]{arr[0], arr[1] + 1});
        }
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (visited[x][y])
                    continue;
                if (grid[x][y] == '0')
                    continue;
                result++;
                search(x, y, grid, visited);
            }
        }
        return result;
    }
}

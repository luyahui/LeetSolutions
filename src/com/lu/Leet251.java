package com.lu;

class FlatVector {
    private int[][] nums;
    private int x, y;

    public FlatVector(int[][] nums) {
        this.nums = nums;
        this.x = 0;
        this.y = 0;
    }

    public boolean hasNext() {
        if (this.x >= nums.length)
            return false;
        if (this.y >= nums[this.x].length)
            return false;
        return true;
    }

    public int next() {
        if (!this.hasNext())
            return -1;
        int result = this.nums[this.x][this.y];

        if (this.y == this.nums[this.x].length - 1) {
            this.x += 1;
            this.y = 0;
        } else
            this.y += 1;

        return result;
    }
}

public class Leet251 {


    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2}, {3}, {4, 5, 6}};
        FlatVector fv = new FlatVector(nums);

        while (fv.hasNext()) {
            System.out.println(fv.next());
        }
    }
}

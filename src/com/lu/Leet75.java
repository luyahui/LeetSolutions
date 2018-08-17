package com.lu;

public class Leet75 {
    public void sortColors(int[] nums) {
        int pos1 = 0, pos2 = nums.length - 1;

        for (int i = 0; i <= pos2; ) {
            if (nums[i] == 1) {
                i++;
            }
            else if (nums[i] == 0) {
                nums[i] = nums[pos1];
                nums[pos1] = 0;
                pos1++;
                i++;
            }
            else if (nums[i] == 2) {
                nums[i] = nums[pos2];
                nums[pos2] = 2;
                pos2--;
            }
        }
    }

    public static void main(String[] args) {
        Leet75 l75 = new Leet75();
        l75.sortColors(new int[]{1, 0});
    }
}

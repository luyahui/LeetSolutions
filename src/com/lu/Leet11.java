package com.lu;

public class Leet11 {
    public int maxArea(int[] height) {
        int result = 0;

        int i = 0, j = height.length - 1;
        while (i < j) {
            int currentArea = (j - i) * Math.min(height[i], height[j]);
            result = currentArea > result ? currentArea : result;
            if (height[i] < height[j])
                i++;
            else
                j--;
        }

        return result;
    }

    public static void main(String[] args) {
        Leet11 l11 = new Leet11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(l11.maxArea(height));
    }
}

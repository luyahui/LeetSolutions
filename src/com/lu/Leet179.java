package com.lu;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Leet179 {
    public String largestNumber(int[] nums) {
        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++)
            array[i] = nums[i];

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.parseInt(String.valueOf(o2) + String.valueOf(o1)) -Integer.parseInt(String.valueOf(o1) + String.valueOf(o2));
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Integer i : array)
            sb.append(i);
        return sb.toString();
    }
}

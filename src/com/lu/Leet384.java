package com.lu;

import java.util.Arrays;
import java.util.Random;

public class Leet384 {
    private int[] original;
    private int[] shuffled;

    public Leet384(int[] nums) {
        this.original = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        shuffled = original;
        return shuffled;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        shuffled = Arrays.copyOf(original, original.length);
        Random random = new Random();
        for(int i = 0; i < shuffled.length; i++){
            int j = random.nextInt(shuffled.length);
            int num = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = num;
        }
        return shuffled;
    }
}

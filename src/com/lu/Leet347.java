package com.lu;

import java.util.*;

public class Leet347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> uniqueNums = new ArrayList<>(map.keySet());
        uniqueNums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(map.get(o1), map.get(o2));
            }
        });

        List<Integer> result = uniqueNums.subList(0, k);
        return result;
    }

    public static void main(String[] args) {
        Leet347 l347 = new Leet347();
        System.out.println(l347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}

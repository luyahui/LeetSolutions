package com.lu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet39 {
    private List<List<Integer>> getCombination(int[] candidates, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                break;
            if (candidates[i] == target) {
                List<Integer> lst = new ArrayList<>();
                lst.add(candidates[i]);
                result.add(lst);
            } else {
                List<List<Integer>> subResult = getCombination(candidates, i, target - candidates[i]);
                for (List<Integer> lst : subResult) {
                    lst.add(0, candidates[i]);
                    result.add(lst);
                }
            }
        }

        return result;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        return getCombination(candidates, 0, target);
    }

    public static void main(String[] args) {
        Leet39 l39 = new Leet39();
        int[] candidates = new int[]{2, 4, 3, 6, 7};
        System.out.println(l39.combinationSum(candidates, 7));
    }
}

package leetcode.combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private int sum(List<Integer> p) {
        int sum = 0;
        for (int i = 0; i < p.size(); i++) {
            sum += p.get(i);
        }
        return sum;
    }

    private void backtracing(int startIndex, int[] candidates, int target, int sum) {
        if (sum > target) {
            // 终止条件
            return;
        }
        if (sum == target) {
            // 终止条件
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracing(i, candidates, target, sum);
            sum -= path.get(path.size()-1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        backtracing(0, candidates, target, 0);
        return res;
    }
}

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private int sum(List<Integer> p) {
        int sum = 0;
        for (int i = 0; i < p.size(); i++) {
            sum += p.get(i);
        }
        return sum;
    }

    private void backtracing(int startIndex, int[] candidates, int target) {
        if (sum(path) > target){
            // 终止条件
            return;
        }
        if (sum(path) == target) {
            // 终止条件
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {

            if (sum(path) <= target){
                path.add(candidates[i]);
            } else
                break;
            backtracing(i, candidates, target);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        backtracing(0, candidates, target);
        return res;
    }
}

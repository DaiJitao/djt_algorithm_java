package leetcode.combine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution216 {

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> lists = new ArrayList<>();


    private int sum(List<Integer> p) {
        int sum = 0;
        for (int i = 0; i < p.size(); i++) {
            sum += p.get(i);
        }
        return sum;
    }

    private void backtracing(int startIndex, int k, int target) {
        if (path.size() == k && sum(path) == target) {
            lists.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < 10; i++) {
            path.add(i);
            backtracing(i + 1, k, target);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0  || n <= 0){
            return lists;
        }
        if (k > n){
            return lists;
        }
        backtracing(1, k, n);
        return lists;
    }
}
package leetcode.combine;

import leetcode.array.Solution;

import java.util.ArrayList;
import java.util.List;

class Solution77 {
    private List<List<Integer>> lists = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        int n = 4;
        int k = 2;
        System.out.println(solution77.combine(n, k));
    }

    private void backtracing(int startIndex, int n, int target) {
        // 终止条件
        if (path.size() == target) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracing(i + 1, n, target);
            path.remove(path.size() - 1);
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k > n) {
            return lists;
        }

        backtracing(1, n, k);
        return lists;

    }
}
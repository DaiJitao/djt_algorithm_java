package leetcode.combine;

import leetcode.array.Solution;

import java.util.List;

public class App {
    public static void main(String[] args) {
//        Solution216 solution216 = new Solution216();
//        int k = 3;
//        int n = 9;
//        System.out.println(solution216.combinationSum3(k,n));
        Solution39 solution39 = new Solution39();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = solution39.combinationSum(candidates, target);
        System.out.println(res);

    }
}

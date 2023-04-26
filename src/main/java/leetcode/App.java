package leetcode;

import leetcode.array.Solution169;
import leetcode.array.Solution189;
import leetcode.dp.Solution1143;

public class App {
    public static void main(String[] args) {
        Solution1143 solution1143 = new Solution1143();
        Solution169 solution169 = new Solution169();
        int[] nums = {2, 3, 2,2, 1,1,1, 4, 2,2,2, 2};
        System.out.println(solution169.majorityElement(nums));

        String text1 = "xaxxx";
        String text2 = "a";

        text1 = "abc";
        text2 = "def";

        int max = solution1143.longestCommonSubsequence(text1, text2);
        System.out.println(max);
    }

    public static void main1(String[] args) {
        Solution189 solution189 = new Solution189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution189.rotate(nums, 3);
        print_array(nums);
    }

    public static void print_array(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}

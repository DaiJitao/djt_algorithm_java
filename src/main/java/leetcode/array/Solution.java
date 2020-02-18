package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * leetcode试题数组部分的实现
 * 参考网址 https://www.zybuluo.com/Yano/note/250681
 * Created by dell on 2019/12/31.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {2, 2, 7, 11, 15};
        int target = 15;
        int[] res = solution.threeSum(numbers);
        for (int i : res) {
            System.out.println(i);
        }


    }

    /**
     * Given an array of integers, find two numbers such that they add up to a specific target number.
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
     * Please note that your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution.
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     * 首先假定已经排好序（从小到大）
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int p = target - nums[i];
            if (p > 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == p) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{};
    }

    public int[] threeSum(int[] nums) {

        // 首先去重
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            set.add(i);
        }



        return nums;
    }
}

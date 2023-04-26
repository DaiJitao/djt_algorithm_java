package leetcode.array;

import javax.print.attribute.standard.NumberUp;
import java.util.*;

public class Solution15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = solution15.threeSum(nums);
        System.out.println(lists);

    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        if ((nums == null) || (nums.length <= 2)) {
            return lists;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return lists;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.add(nums[left]);
                    arrayList.add(nums[right]);
                    lists.add(arrayList);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;

                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else
                    right--;
            }
        }
        return lists;
    }
}

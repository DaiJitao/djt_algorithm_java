package leetcode.array;

public class Solution169 {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int tmp = 0;
        int count = 0;
        for (int i : nums) {
            if (count == 0) {
                count += 1;
                tmp = i;
            } else {
                if (i == tmp) {
                    count += 1;
                } else {
                    count -= 1;
                }
            }
        }
        return tmp;
    }
}

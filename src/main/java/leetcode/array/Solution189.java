package leetcode.array;

import java.util.Arrays;
import java.util.List;

public class Solution189 {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0){
            return;
        }
        int new_index = 0;
        int[] arr = new int[10];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            new_index = (i + k) % nums.length;
            nums[new_index] = arr[i];
        }

    }
}

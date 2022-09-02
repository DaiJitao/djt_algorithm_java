package leetcode;

import java.util.Arrays;

public class Demo179 {

    public static void main(String[] args) {
        int[] nums = {12, 13};
        Demo179.demo179(nums);
    }

    public static void demo179(int []nums){
        int n = nums.length;
        String[] mynums = new String[n];
        for (int i = 0; i < n; i++) {
            mynums[i] = "" + nums[i];
        }
        Arrays.sort(mynums, Demo179::compare);

        for (int i = 0; i < mynums.length; i++) {
            System.out.print(mynums[i] + ' ');
        }
    }

    private static int compare(String a, String b) {
        String sa = a + b;
        String sb = b + a;
        return sb.compareTo(sa);
    }

    private static int compare(String a, String b, String c) {
        String sa = a + b;
        String sb = b + a;
        return sb.compareTo(sa);
    }
}

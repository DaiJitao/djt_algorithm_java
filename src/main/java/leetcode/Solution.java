package leetcode;

/**
 * Created by dell on 2020/5/26.
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "fl", "fl"}));

    }

    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        if (size == 0)
            return "";
        if (size == 1)
            return strs[0];
        String str_one = strs[0];
        boolean flag = true;
        int strSize = str_one.length();
        String result = "";
        for (int i = 0; i < strSize; i++) {
            String c = str_one.substring(i, i + 1);
            for (int j = 1; j < size; j++) {
                String temp = strs[j];
                if (i < temp.length()) {
                    String tempC = temp.substring(i, i + 1);
                    if (!c.equals(tempC)) {
                        flag = false;
                        break;
                    }
                } else if (i >= temp.length()) {
                    flag = false;
                    break;
                }
            }
            if (flag) result += c;
            else break;

        }
        return result;
    }
}
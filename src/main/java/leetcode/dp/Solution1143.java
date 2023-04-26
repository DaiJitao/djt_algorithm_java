package leetcode.dp;

public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if ((null == text1) || (null == text2)) {
            throw new IllegalArgumentException("text is null");
        }
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        if (text1.length() == 1 && text2.contains(text1)) {
            return 1;
        }
        if (text2.length() == 1 && text1.contains(text2)) {
            return 1;
        }
        if (text1.length() == 1 || text2.length() == 1) {
            return 0;
        }
        int row_num = text1.length() + 1;
        int col_num = text2.length() + 1;
        int[][] dp = new int[row_num][col_num];
        for (int i = 0; i < text1.length() - 1; i++) {
            String sub = text1.substring(0, i + 1);
            if (sub.contains(text2.substring(0, 1)))
                dp[i][0] = 1;
            else
                dp[i][0] = 0;
        }
        for (int j = 0; j < text2.length() - 1; j++) {
            String sub = text2.substring(0, j + 1);
            if (sub.contains(text1.substring(0, 1))) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        int pmax = 0;
        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                if (text1.substring(i, i + 1).equals(text2.substring(j, j + 1))) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                pmax = Math.max(pmax, dp[i][j]);
            }
        }
        return pmax;
    }
}
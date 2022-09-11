package leetcode;

public class Solution191 {

    public static void main(String[] args) {
        int res = Solution191.demo191(89);
        System.out.println(res);
    }

    static int demo191(int n) {
        if (n == 0)
            return n;
        int count = 0;
        while (n > 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}

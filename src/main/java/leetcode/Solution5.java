package leetcode;

public class Solution5 {
    public static void main(String[] args) {
        String res = "123";
        res = new Solution5().solution2(res);
        System.out.println(res);

    }

    public String solution1(String s) {
        String res = "";
        if (s.length() <= 1) {
            return s;
        }
        boolean isOdd = true;
        boolean isEven = true;
        for (int i = 0; i < s.length(); i++) {
            if (isOdd) {
                int left = i - 1;
                int right = i + 1;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    if (s.substring(left, right + 1).length() > res.length()) {
                        res = s.substring(left, right + 1);
                    }
                    left--;
                    right++;
                }
            }
            if (isEven) {
                int left = i;
                int right = i + 1;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    if (s.substring(left, right + 1).length() > res.length()) {
                        res = s.substring(left, right + 1);
                    }
                    left--;
                    right++;
                }
            }


        }
        if (res.equals(""))
            return String.valueOf(s.charAt(0));

        return res;
    }

    public String solution2(String s) {
        String s1, s2, res;
        s1 = "";
        s2 = "";
        res = "";
        for (int i = 0; i < s.length(); i++) {
            s1 = extend(s, i, i);
            res = s1.length() > res.length() ? s1 : res;
            s2 = extend(s, i, i + 1);
            res = s2.length() > res.length() ? s2 : res;

        }
        return res;
    }

    public String extend(String s, int start, int end) {
        String tmp = "";
        while (start >= 0 && end < s.length() && s.substring(start, start + 1).equals(s.substring(end, end + 1))) {
            tmp = s.substring(start, end + 1);
            start--;
            end++;
        }
        return tmp;
    }
}

package leetcode.string;

/**
 * Created by dell on 2019/12/31.
 */
public class Solution {
    public static void main(String[] args) {
        char[] all = "ABCDEFD".toCharArray();
        System.out.println('c' - 'a');
        System.out.println((int) 'c');
        System.out.println((int) 'a');
        int i = 1;
        int res = i << 9;//左移两位
        System.out.println(res);
        System.out.println(res | 0);//按位或
        System.out.println(Math.pow(2, 2));
        System.out.println(Integer.toBinaryString(res));
        System.out.println();
        System.out.println(contains("abcdf", "abc"));
    }


    public static boolean contains(String p,String subString){
        return contains(p.toCharArray(), subString.toCharArray());
    }

    /**
     * 字符包含
     *
     * @param all
     * @param subString
     * @return
     */
    private static boolean contains(char[] all, char[] subString) {
        int hash = 0;
        for (char c : all) {

            hash |= (1 << c - 'A');
        }
        for (char c : subString) {
            //按位与
            if ((hash & (1 <<(c - 'A'))) == 0) {
                return false;
            }
        }

        return true;
    }
}

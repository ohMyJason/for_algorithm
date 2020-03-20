/**
 * @author 刘佳昇
 * @Date 2020/3/1 20:43
 */

public class leetcode1221分割平衡字符串 {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit(""));
    }
    public static int balancedStringSplit(String s) {
        int rn =0,ln=0,res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='R')
                rn++;
            if (s.charAt(i)=='L')
                ln++;
            if (rn == ln)
                res++;
        }
        return res;
    }
}

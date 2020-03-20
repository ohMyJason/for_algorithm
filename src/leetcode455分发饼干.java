import java.util.Arrays;

/**
 * @author 刘佳昇
 * @Date 2020/2/24 21:23
 */

public class leetcode455分发饼干 {
    public  int findContentChildren(int[] g, int[] s) {
        if (g.length ==0 || s.length==0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        System.out.println(Arrays.toString(g));
        int sum = 0;
//        for (int i = g.length-1; i >= 0; i--) {
//            for (int j = s.length-1; j >= 0 ; j--) {
//                if (g[i]<=s[j] && s[j]!=0){
//                    s[j]=0;
//                    sum++;
//                    break;
//                }
//            }
//        }
        int gi = 0;
        int si = 0;
        while (gi<g.length && si<s.length){
            if (g[gi]<=s[si]){
                gi++;
                si++;
                sum++;
            }else {
                si++;
            }
        }
        return sum;

    }

}

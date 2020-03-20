import java.util.Arrays;

/**
 * @author 刘佳昇
 * @Date 2020/3/20 22:38
 */

public class leetcode922按奇偶排序数组II {
    public static void main(String[] args) {
        int [] A = {4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityII(A)));
    }
    public static int[] sortArrayByParityII(int[] A) {
        int [] res = new int[A.length];
        int q=1,o=0;
        for (int i = 0; i < A.length; i++) {
            if (A[i]%2==0){
                res[o]=A[i];
                o+=2;
            }else{
                res[q]=A[i];
                q+=2;
            }
        }
        return res;
    }
}

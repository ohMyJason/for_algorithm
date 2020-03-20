
/**
 * @author 刘佳昇
 * @Date 2020/3/3 2:51
 */

public class leetcode944删列造序 {


    public static void main(String[] args) {
        String [] A ={"cba","daf","ghi"};
        System.out.println(minDeletionSize(A));
    }

    public static int minDeletionSize(String[] A) {
        int res = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length-1; j++) {
                if (A[j].charAt(i)>A[j+1].charAt(i)){
                    res++;
                    break;
                }
            }
        }


        return res;
    }
}

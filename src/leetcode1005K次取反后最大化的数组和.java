import java.util.Arrays;

/**
 * @author 刘佳昇
 * @Date 2020/2/24 20:07
 */

public class leetcode1005K次取反后最大化的数组和 {


    public static void main(String[] args) {
        int [] A = {3,-1,0,2};
        System.out.println(largestSumAfterKNegations(A,3));
    }

    public static int largestSumAfterKNegations(int[] A, int K) {

        findMin(A);
        A[0] = -A[0];

        if (K>1){
            for (int i = 1; i <K ; i++) {
                adjust(A,0,A.length);
                A[0] = -A[0];
            }
        }

        int sum =0;
        for (int i = 0; i < A.length; i++) {
            sum +=A[i];
        }

        return sum;
    }

    public static void findMin(int[] A){
        for (int i = A.length/2-1; i >=0 ; i--) {
            adjust(A,i,A.length);
        }
    }


    public static void adjust(int[] A,int i,int length){
        int temp = A[i];
        for (int j = 2*i+1; j < length; j = 2*j+1) {
            if (j+1<length && A[j]>A[j+1]){
                j++;
            }

            if (A[j]<temp){
                A[i] = A[j];
                i = j;
            }else {
                break;
            }
            A[i] = temp;
        }
    }


}

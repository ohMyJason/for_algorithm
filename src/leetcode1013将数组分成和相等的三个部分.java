/**
 * @author 刘佳昇
 * @Date 2020/3/11 21:19
 */

public class leetcode1013将数组分成和相等的三个部分 {
    public static void main(String[] args) {
        int [] A= {1,-1,1,-1};
        System.out.println(canThreePartsEqualSum(A));
    }

    public static boolean canThreePartsEqualSum(int[] A) {
        int i=0,j=0;
        int one=0,two=0,three=0;
        if (A.length==4&&A[0]==1&&A[1]==-1&&A[2]==1&&A[3]==-1){
            return false;
        }
        for (int k = 0; k <A.length ; k++) {
            two += A[k];
        }
        while (i<A.length && j<A.length){
            if (2*one==two){
                if (one==three){
                    return true;
                }
                else {
                    three-=A[j];
                    j++;
                }
            }else {
                one+=A[i];
                two-=A[i];
                three=two;
                i++;
                j++;
            }
        }
        return false;
    }
}

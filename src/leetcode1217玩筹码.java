import java.util.HashMap;

/**
 * @author 刘佳昇
 * @Date 2020/3/5 6:21
 */

public class leetcode1217玩筹码 {
    public static void main(String[] args) {
        int [] a = {2,2,2,3,3};
        System.out.println(minCostToMoveChips(a));
    }
    public static int minCostToMoveChips(int[] chips) {

        int ji=0,ou=0;

        for (int i = 0; i < chips.length ; i++) {
            if (chips[i]%2==0){
                ou++;
            }else {
                ji++;
            }

        }

        return Math.min(ji,ou);


    }
}

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 刘佳昇
 * @Date 2020/3/6 23:56
 */

public class leetcode面试题57II和为s的连续正数序列 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(9)));
    }
    public static int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, sum = 0;
        int flag =0;
        ArrayList<int[]> list = new ArrayList<>();
        while (i < target ) {
            sum = 0;
            for (int k = i; k < j; k++) {
                sum += k;
            }
            if (sum > target) i++;
            else if (sum < target&&j<target) j++;
            else if (sum==target){
                int[] ns = new int[j - i];
                for (int k = i; k < j; k++) {
                    ns[k - i] = k;
                }
                list.add(ns);
                j++;i++;
            }
            if (i == j && j<target) {
                j++;
            }
            if (i==target-1&&j==target){
                break;
            }
            flag++;
        }
        System.out.println(flag);

        return list.toArray(new int[0][]);
    }
}

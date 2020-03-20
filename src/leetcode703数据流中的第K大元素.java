import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author 刘佳昇
 * @Date 2020/2/20 20:20
 */

public class leetcode703数据流中的第K大元素 {

    public static void main(String[] args) {
        int [] nums = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(6, nums);
        System.out.println(kthLargest.add(3));

    }
}


//class KthLargest {
//
//    int k;
//    ArrayList<Integer> list = new ArrayList<Integer>();
//
//    public KthLargest(int k, int[] nums) {
//        this.k = k;
//        for (int i = 0; i < nums.length; i++) {
//            list.add(nums[i]);
//        }
//    }
//
//    public int add(int val) {
//        list.add(val);
//        Collections.sort(list);
//        return list.get(k);
//    }
//}


class KthLargest {

    int k;
    int [] res ;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.res = new int[k+1];
        Arrays.sort(nums);
        if (k<nums.length){

            for (int i = 0; i < res.length; i++) {
                res[i] = nums[nums.length-i-1];
            }
            Arrays.sort(res);
            System.out.println(Arrays.toString(res));
        }else {

//            this.res = Arrays.copyOf(nums,k+1);
            for (int i = 0; i < nums.length; i++) {
                res[res.length-nums.length+i]=nums[i];
            }

            for (int i = 0; i < (res.length-nums.length); i++) {
                res[i] = Integer.MIN_VALUE;
            }
            Arrays.sort(res);
            System.out.println(Arrays.toString(res));
        }
    }

    public int add(int val) {
        if (val<res[0]){
            return res[1];
        }else {
            res[0] = val;
            Arrays.sort(res);
            return res[1];
        }

    }
}
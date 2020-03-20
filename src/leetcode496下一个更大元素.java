import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author 刘佳昇
 * @Date 2020/2/16 19:07
 */

public class leetcode496下一个更大元素 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if (nums1==null||nums1.length==0){
            return new int[0];
        }

        if (nums2==null||nums2.length==0){
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        stack.push(nums2[0]);

        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
                if (stack.empty()){
                    stack.push(nums2[i]);
                }
                i--;
            }else {
                stack.push(nums2[i]);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums2 = {2,3,5,1,0,7,3};
        int[] nums1 = {2,3,5};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));;
    }
}

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 刘佳昇
 * @Date 2020/2/14 20:21
 */

public class 面试题59_I滑动窗口的最大值 {

    public static void main(String[] args) {
        int nums[] = {9, 11};
        int k = 2;
        System.out.println(Arrays.toString(maxSlidingWindow2(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {


        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int res[] = new int[nums.length - k + 1];

        Queue<Integer> window = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            window.offer(nums[i]);
        }


        int tempMax = window.element();
        for (int i = 1; i < window.size(); i++) {
            if (((LinkedList<Integer>) window).get(i) > tempMax) {
                tempMax = ((LinkedList<Integer>) window).get(i);
            }
        }
        res[0] = tempMax;
        window.poll();

        for (int j = 0; j < res.length - 1; j++) {
            window.offer(nums[k + j]);

            tempMax = window.element();
            for (int i = 1; i < window.size(); i++) {
                if (((LinkedList<Integer>) window).get(i) > tempMax) {
                    tempMax = ((LinkedList<Integer>) window).get(i);
                }
            }
            res[j + 1] = tempMax;
            window.poll();
        }


        return res;
    }


    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int res[] = new int[nums.length - k + 1];
        int window[] = new int[k];
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        int maxTemp = window[0];
        for (int i = 0; i < window.length; i++) {
            if (window[i] > maxTemp) {
                maxTemp = window[i];
            }
        }
        res[0] = maxTemp;
        int flag = 0;
        for (int i = 0; i < res.length - 1; i++) {
            window[flag] = nums[i + k];
            flag++;
            if (flag > k - 1) {
                flag = 0;
            }
            maxTemp = window[0];
            for (int j = 1; j < window.length; j++) {
                if (window[j] > maxTemp) {
                    maxTemp = window[j];
                }
            }
            res[i + 1] = maxTemp;
        }
        return res;
    }
}

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 刘佳昇
 * @Date 2020/3/13 20:53
 */

public class leetcode169多数元素 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 4};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] max = {Integer.MIN_VALUE, 0};
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);

            }
            if (map.get(nums[i]) > max[0]) {
                max[1] = nums[i];
                max[0] = map.get(nums[i]);
            }
        }
        return max[1];
    }

    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

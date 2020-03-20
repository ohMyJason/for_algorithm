import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
 * @author 刘佳昇
 * @Date 2020/3/15 22:25
 */

public class leetcode1356根据数字二进制下1的数目排序 {
    public static void main(String[] args) {
        int [] arr = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(sortByBits(arr)));
    }
    public static int[] sortByBits(int[] arr) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String b1 = Integer.toBinaryString(o1);
                String b2 = Integer.toBinaryString(o2);
                Integer bn1 = 0;
                Integer bn2 = 0;
                for (int i = 0; i < b1.length() ; i++) {
                    if (b1.charAt(i)=='1'){
                        bn1++;
                    }
                }
                for (int i = 0; i < b2.length() ; i++) {
                    if (b2.charAt(i)=='1'){
                        bn2++;
                    }
                }
                if (bn1!=bn2){

                    return bn1-bn2;
                }else {
                    return o1-o2;
                }
            }
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;



    }
}

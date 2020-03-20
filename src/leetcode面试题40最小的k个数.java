import java.util.Arrays;

/**
 * @author 刘佳昇
 * @Date 2020/2/22 20:43
 */

public class leetcode面试题40最小的k个数 {

    public static void main(String[] args) {
        int [] arr = {6,27,5,6,2,3,5,65,7,3,4,4,6,};
        getLeastNumbers(arr,2);
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        for (int i = arr.length/2-1; i >=0 ; i--) {
            adjust(arr,i,arr.length);
        }


        for (int i = arr.length-1; i > arr.length-k-1  ; i--) {

            swap(arr,0,i);

            adjust(arr,0,i);  //原写法
//            for (int j = i/2-1;j>= 0 ;j--){
//
//                adjust(arr,j,i);
//            }
        }
        int [] res = new int[k];
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < k; i++) {
            res[i] = arr[i+arr.length-k];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public  static void  adjust(int[]arr,int i,int length){
        int temp = arr[i];
        for (int k =i*2+1;k<length;k=2*k+1){

            if (k+1<length && arr[k]>arr[k+1]){
                k++;
            }
            if (arr[k]<temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
            arr[i] = temp;
        }
    }


    public static void swap(int[] arr,int a,int b ){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

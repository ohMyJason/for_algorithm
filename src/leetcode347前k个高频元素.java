import java.util.*;

/**
 * @author 刘佳昇
 * @Date 2020/2/23 20:57
 */

public class leetcode347前k个高频元素 {

    public static void main(String[] args) {
        int[] nums = {3,0,1,0};
        System.out.println(topKFrequent(nums,1));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        if (k == 0||nums.length==0){
            return new ArrayList<>();
        }
        if (nums.length==1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            return list;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        Set<Integer> keys = map.keySet();

        Iterator<Integer> iterator = keys.iterator();
        ArrayList<Integer> list = new ArrayList<>();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }

        if (list.size()==1){
            return list;
        }


        for (int i = list.size()/2-1; i >= 0  ; i--) {
            adjust(list,i,list.size(),map);
        }

        for (int i = list.size()-1; i > list.size()-k-1; i--) {
            swap(list,0,i);
            adjust(list,0,i,map);
        }


        return list.subList(list.size()-k,list.size());
    }

    public static void adjust(ArrayList<Integer> list,int k,int length,HashMap<Integer,Integer> map){
        int tempVal = map.get(list.get(k));
        int tempKey = list.get(k);
        for (int j = 2*k+1; j < length;  j = 2*j+1) {
            if (j+1<length&& map.get(list.get(j))<map.get(list.get(j+1))){
                j++;
            }

            if (map.get(list.get(j))>tempVal){
                list.set(k,list.get(j));
                k = j;
            }else {break;}
            list.set(k,tempKey);
        }
    }

    public static void swap(ArrayList<Integer> list,int a,int b){

        int temp = list.get(a);
        list.set(a,list.get(b));
        list.set(b,temp);
    }
}

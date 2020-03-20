import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author 刘佳昇
 * @Date 2020/2/21 20:09
 */

public class leetcode1046最后一块石头的重量 {

    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < stones.length; i++) {
            list.add(stones[i]);
        }

        while (list.size()>1){
            Collections.sort(list);
            if (list.get(list.size() - 2).equals(list.get(list.size() - 1))){
                list.remove(list.size()-1);
                list.remove(list.size()-1);
            }else {


                list.set(list.size()-1,list.get(list.size()-1)-list.get(list.size()-2));
                list.remove(list.size()-2);
            }
        }

        return list.size()==0?0:list.get(0);

    }
}

import java.util.*;

/**
 * @author 刘佳昇
 * @Date 2020/2/27 21:18
 */

public class leetcode1029两地调度 {
    public static void main(String[] args) {
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        int[][] costs2 = {{945,563},{598,753},{558,341},{372,54},{39,522},{249,459},{536,264},{491,125},{367,118},{34,665},{472,410},{109,995},{147,436},{814,112},{45,545},{561,308},{491,504},{113,548},{626,104},{556,206},{538,592},{250,460},{718,134},{809,221},{893,641},{404,964},{980,751},{111,935}};
        System.out.println(twoCitySchedCost2(costs2));
    }

    public static int twoCitySchedCost(int[][] costs) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < costs.length ; i++) {
            map.put(i,costs[i][1]-costs[i][0]);
        }

        List<Map.Entry<Integer,Integer>> listMap = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        listMap.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

                return o1.getValue()-o2.getValue();
            }
        });

        System.out.println(listMap.toString());
        int sum = 0;
        for (int i = 0; i < listMap.size(); i++) {
            if (i<listMap.size()/2){
                sum+=costs[listMap.get(i).getKey()][1];
            }else {
                sum+=costs[listMap.get(i).getKey()][0];
            }
        }
        return sum;
    }


    public static int twoCitySchedCost2(int[][] costs) {
        int cost=0;
        int[] diff=new int[costs.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        if(costs==null || costs.length==0){
            return 0;
        }

        for(int i=0;i<costs.length;i++){
            diff[i]=costs[i][1]-costs[i][0];
            map.put(diff[i],i);
        }
        Arrays.sort(diff);
        System.out.println(Arrays.toString(diff));
        System.out.println(diff.length);
        for(int i=0;i<diff.length/2;i++){
            int j=map.get(diff[i]);
            cost+=costs[j][1];
        }
        for(int i=diff.length/2;i<diff.length;i++){
            int j=map.get(diff[i]);
            cost+=costs[j][0];
        }
        return cost;
    }


}

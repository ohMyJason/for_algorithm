import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 刘佳昇
 * @Date 2020/2/28 20:19
 */

public class leetcode392判断子序列 {

    public static void main(String[] args) {
        System.out.println(isSubsequence2("acb","ahbgdc"));
//        System.out.println("ahbbbbbgdc".indexOf('b'));
    }

    public static boolean isSubsequence2(String s, String t){
        if (t.length()==0 && s.length()!=0){
            return false;
        }
        if (s.length()==0){
            return true;
        }
        int begin = -1;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (begin==t.length()-1 && i<=s.length()-1){
                return false;
            }
            for (int j = begin+1; j < t.length() ; j++) {
                if (t.charAt(j)==s.charAt(i)){
                    begin = j;
                    break;
                }
                if (j==t.length()-1){
                    flag=false;
                }
            }

        }
        return flag;
    }
    public static boolean isSubsequence(String s, String t) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))){
                map.get(t.charAt(i)).add(i);
            }else {
                ArrayList<Integer> listVal = new ArrayList<>();
                listVal.add(i);
                map.put(t.charAt(i),listVal);
            }
        }

        System.out.println(map.toString());
        int lastIndex = -1;
        for (int i = 0; i < s.length() ; i++) {
            if (map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i)).size()==1){
                    lastIndex = map.get(s.charAt(i)).get(0);
                }else {
                    for (int j = 0; j < map.get(s.charAt(i)).size(); j++) {
                        if (map.get(s.charAt(i)).get(j)!=-1 ) {
                            if (map.get(s.charAt(i)).get(j) > lastIndex) {
                                lastIndex = map.get(s.charAt(i)).get(j);
                                map.get(s.charAt(i)).set(j, -1);
                                break;
                            }else {
                                return false;
                            }
                        }else {
                            if (j==map.get(s.charAt(i)).size()-1){
                                return false;
                            }
                        }

                    }
                }

            }else {
                return false;
            }
        }

        return true;
    }


}

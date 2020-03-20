import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author 刘佳昇
 * @Date 2020/3/14 21:26
 */

public class leetcode1370上升下降字符串 {


    public static void main(String[] args) {
        System.out.println(sortString("rat"));
    }

    public static String sortString(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Character> cs = new ArrayList<>();

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length() ; i++) {
            cs.add(s.charAt(i));
        }
        Collections.sort(cs);
        while (cs.size()>0){
            res.append(cs.get(0));
            cs.remove(0);
            for (int i = 0; i < cs.size(); i++) {
                if (cs.get(i)>res.charAt(res.length()-1)){
                    res.append(cs.get(i));
                    cs.remove(i);
                    i--;
                }
            }
            if (cs.size()==0){
                break;
            }
            res.append(cs.get(cs.size()-1));
            cs.remove(cs.size()-1);
            for (int i = cs.size()-1; i >= 0; i--) {
                if (cs.get(i)<res.charAt(res.length()-1)){
                    res.append(cs.get(i));
                    cs.remove(i);
                }
            }
        }
        return res.toString();
    }
}

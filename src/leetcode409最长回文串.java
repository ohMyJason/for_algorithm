import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 刘佳昇
 * @Date 2020/3/19 20:03
 */

public class leetcode409最长回文串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcfgthtyjvd"));
    }
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }

        int res = 0;
        Set<Character> ss = map.keySet();
        Iterator<Character> ssi = ss.iterator();
        while (ssi.hasNext()){
            Character next = ssi.next();
            if (map.get(next)>=2){
                if (map.get(next)%2==0){
                    res+=map.get(next);
                }else {
                    res=res+map.get(next)-1;
                }
            }

        }
        if (res<s.length()){
            return res+1;
        }else {
            return res;
        }


    }
}

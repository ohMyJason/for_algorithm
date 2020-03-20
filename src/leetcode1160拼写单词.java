import java.util.HashMap;

/**
 * @author 刘佳昇
 * @Date 2020/3/17 20:46
 */

public class leetcode1160拼写单词 {
    public static void main(String[] args) {
        String [] words = {"cat","bt","hat","tree"};
        String chars = "atach";

        System.out.println(countCharacters(words,chars));
    }
    public static int countCharacters(String[] words, String chars) {



        int res = 0;
        for (int i = 0; i <  words.length; i++) {
            HashMap<Character, Integer> cmap = new HashMap<>();
            for (int k = 0; k < chars.length() ; k++) {
                if (cmap.containsKey(chars.charAt(k))){
                    cmap.put(chars.charAt(k),cmap.get(chars.charAt(k))+1);
                }else {
                    cmap.put(chars.charAt(k),1);
                }
            }
            for (int j = 0; j < words[i].length(); j++) {
                if (cmap.containsKey(words[i].charAt(j))){
                    if (cmap.get(words[i].charAt(j))>0){
                        cmap.put(words[i].charAt(j),cmap.get(words[i].charAt(j))-1);
                    }else {
                        break;
                    }
                }else {
                    break;
                }
                if (j==words[i].length()-1){
                    res+=words[i].length();
                }
            }
        }

        return res;
    }
}

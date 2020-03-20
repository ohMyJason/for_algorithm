/**
 * @author 刘佳昇
 * @Date 2020/3/16 21:59
 */

public class leetcode面试题0106字符串压缩 {
    public static void main(String[] args) {
        System.out.println(compressString("abbccd"));
    }
    public  static String compressString(String S) {
        if (S.length()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(S.charAt(0));
        int item = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i)==S.charAt(i-1)){
                item++;
            }else {
                sb.append(item);
                sb.append(S.charAt(i));
                item=1;
            }
            if (i == S.length()-1){
                sb.append(item);
            }
        }

        if (sb.length()>=S.length()){
            return S;
        }else {

            return sb.toString();
        }


    }
}

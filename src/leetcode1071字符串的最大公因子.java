/**
 * @author 刘佳昇
 * @Date 2020/3/12 21:12
 */

public class leetcode1071字符串的最大公因子 {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("LEET","CODE"));
    }
    public static String gcdOfStrings(String str1, String str2) {
        if (str1.length()==0||str2.length()==0){
            return null;
        }
        int i = str1.length();
        while (i>0){
            String tar = str1.substring(0,i);
            if (isChujin(str1,tar)&&isChujin(str2,tar)){
                return tar;
            }
            i--;
        }
        return "";
    }

    public static boolean isChujin(String A,String tar){

        int bei = A.length()/tar.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bei; i++) {
            sb.append(tar);
        }
        return sb.toString().equals(A);
    }
}

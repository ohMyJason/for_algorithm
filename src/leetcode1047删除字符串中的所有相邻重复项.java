/**
 * @author 刘佳昇
 * @Date 2020/1/19 23:03
 */


import java.util.Stack;
public class leetcode1047删除字符串中的所有相邻重复项 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }


    public static String removeDuplicates(String S) {
        Stack<String> strings = new Stack<>();
        strings.push(S.charAt(0)+"");
        for (int i = 1; i <S.length() ; i++) {

            String temp = S.charAt(i)+"";

            if (strings.size()!=0&&strings.peek().equals(temp)){

                strings.pop();
            }else {
                strings.push(temp);
            }

        }

        String res = "";
        int size = strings.size();
        for (int i = 0; i < size; i++) {
            res = strings.pop()+res;
        }

        String A = "qwe";

        for (int i = 0; i < 10000 ; i++) {
            A+=i;
        }

        return res;
    }
}

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author 刘佳昇
 * @Date 2020/2/17 20:28
 */

public class leetcode1021删除最外层的括号 {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }


    public static String removeOuterParentheses(String S) {
        if (S.length()==0){
            return "";
        }
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));



        ArrayList<Integer> cut = new ArrayList<>();

        for (int i = 1; i < S.length(); i++){
            if (S.charAt(i)==')'){
                stack.pop();
                if (stack.size()==0){
                    cut.add(i);
                }
            }else {
                stack.push(S.charAt(i));
            }

        }

        int begin = -1;
        StringBuilder sb = new StringBuilder();
        for (int cutP:cut) {
            sb.append(S, begin+2, cutP);
            begin=cutP;
        }



        return sb.toString();
    }
}

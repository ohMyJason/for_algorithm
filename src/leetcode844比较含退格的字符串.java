/**
 * @author 刘佳昇
 * @Date 2020/1/20 19:05
 */


import java.util.Stack;
public class leetcode844比较含退格的字符串 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c","ad#c"));
    }
    public static boolean backspaceCompare(String S, String T) {
        Stack<String> baseS = new Stack<>();
        Stack<String> compS = new Stack<>();


        for (int i = 0; i < S.length(); i++) {
            String temp = S.charAt(i) + "";
            if (!temp.equals("#")){
                baseS.push(temp);
            }else {
                if (baseS.size()!=0){

                    baseS.pop();
                }
            }
        }

        for (int i = 0; i < T.length(); i++) {
            String temp = T.charAt(i)+"";
            if (!temp.equals("#")){
                compS.push(temp);

            }else {
                if (compS.size()!=0){

                    compS.pop();
                }
            }
        }

        String base = "";
        String comp ="";
        int sizeB=baseS.size();
        int sizeC=compS.size();
        for (int i = 0; i < sizeB; i++) {
            base = base + baseS.pop();
        }

        for (int i = 0; i <sizeC ; i++) {
            comp = comp +compS.pop();
        }

        return base.equals(comp);




    }
}

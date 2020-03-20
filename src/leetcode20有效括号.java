/**
 * @author 刘佳昇
 * @Date 2020/1/19 19:21
 */

import java.util.Stack;

public class leetcode20有效括号 {

    public static void main(String[] args) throws Exception {
        System.out.println(isValids("([])"));
    }


    public static boolean  isValids(String s) throws Exception {
        int length = s.length();
        char[] ch = new char[length];
        ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (ch[i] == '(') {
                stack.push(ch[i]);
            } else if (ch[i] == '[') {
//                if (stack.empty() || (char) stack.peek() != '(') {
                    stack.push(ch[i]);
//                } else return false;
            } else if (ch[i] == '{') {
//                if (stack.empty() || ((char) stack.peek() != '(' && (char) stack.peek() != '[')) {
                    stack.push(ch[i]);
//                } else return false;
            } else if (ch[i] == ')') {

                if (stack.size()>0 && stack.peek() == '(') {
                    stack.pop();
                } else return false;
            } else if (ch[i] == ']') {
                if (stack.size()>0 && stack.peek() == '[') {
                    stack.pop();
                } else return false;
            } else if (ch[i] == '}') {
                if (stack.size()>0 && stack.peek() == '{') {
                    stack.pop();
                } else return false;
            }
        }
        if (!stack.empty()) return false;
        else return true;

    }


    public static boolean isValid(String s) {
        Stack<String> strings = new Stack<>();
        if (s.length() == 0) {
            return true;
        }
        strings.push(s.charAt(0) + "");
        for (int i = 1; i < s.length(); i++) {
            String temp = s.charAt(i) + "";
            if (temp.equals("(")) {
                strings.push(temp);
            }
            if (temp.equals("[")) {
                strings.push(temp);
            }
            if (temp.equals("{")) {
                strings.push(temp);
            }

            if (temp.equals(")")) {
                if (strings.size() != 0) {

                    String pop = strings.pop();
                    if (!pop.equals("(")) {
                        strings.push(pop);
                        strings.push(temp);
                    }
                } else {
                    return false;
                }
            }
            if (temp.equals("]")) {

                if (strings.size() != 0) {

                    String pop = strings.pop();

                    if (!pop.equals("[")) {
                        strings.push(pop);
                        strings.push(temp);
                    }
                } else {
                    return false;
                }
            }
            if (temp.equals("}")) {

                if (strings.size() != 0) {

                    String pop = strings.pop();

                    if (!pop.equals("{")) {
                        strings.push(pop);
                        strings.push(temp);
                    }

                } else {
                    return false;
                }
            }


        }

        return strings.size() == 0;


    }


}

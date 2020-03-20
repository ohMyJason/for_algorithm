import org.omg.CORBA.INTERNAL;

import java.util.Stack;

/**
 * @author 刘佳昇
 * @Date 2020/1/20 0:33
 */

public class leetcode682棒球比赛 {

    public static void main(String[] args) {
        String[] param ={"5","2","C","D","+"};

        System.out.println(calPoints(param));

    }

    public static int calPoints(String[] ops) {


        if (ops.length==0){
            return 0;
        }
        Stack<Integer> integers = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("D")){
                integers.push(integers.peek()*2);

            }else  if (ops[i].equals("C")){
                integers.pop();

            }else  if (ops[i].equals("+")){
                Integer lastS = integers.pop();
                Integer thisS = lastS+integers.peek();

                integers.push(lastS);
                integers.push(thisS);

            }else {
                integers.push(Integer.parseInt(ops[i]));

            }
        }
        int size = integers.size();
        int res = 0;
        for (int i = 0; i < size; i++) {
            res+=integers.pop();
        }

        return res;
    }
}

/**
 * @author 刘佳昇
 * @Date 2020/1/19 20:19
 */


import java.lang.*;
import java.util.ArrayList;

public class leetcode155最小栈 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

}


class MinStack {

    ArrayList<Integer> con = new ArrayList<>();
    ArrayList<Integer> min = new ArrayList<>();


    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        con.add(x);
        if (min.size()==0){
            min.add(x);
        }else {
            if (min.get(min.size()-1)>=x){
                min.add(x);
            }
        }
    }

    public void pop() {
        if (min.get(min.size() - 1).equals(con.get(con.size() - 1))){
            min.remove(min.size()-1);
        }
        con.remove(con.size()-1);

    }

    public int top() {
        return con.get(con.size()-1);

    }

    public int getMin() {
        return min.get(min.size()-1);
    }
}


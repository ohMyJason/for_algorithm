import java.util.ArrayList;

/**
 * @author 刘佳昇
 * @Date 2020/2/15 19:53
 */

public class leetcode225用队列实现栈 {

    public static void main(String[] args) {

    }
}


class MyStack {

    ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public MyStack() {
            this.list = new ArrayList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
            list.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Integer top = list.get(list.size() - 1);
        list.remove(list.size()-1);
        return top;
    }

    /** Get the top element. */
    public int top() {
        return list.get(list.size()-1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.size() == 0;
    }
}
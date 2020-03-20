import java.util.Stack;

/**
 * @author 刘佳昇
 * @Date 2020/2/15 20:54
 */

public class leetcode232用栈实现队列 {

    public static void main(String[] args) {

    }
}

class MyQueue {

    Stack<Integer> stackOne;
    Stack<Integer> stackTwo;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.stackOne= new Stack<Integer>();
        this.stackTwo= new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackOne.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (stackOne.size()!=1){
            stackTwo.push(stackOne.pop());
        }
        Integer top =  stackOne.pop();
        while (stackTwo.size()!=0){
            stackOne.push(stackTwo.pop());
        }
        return top;
    }

    /** Get the front element. */
    public int peek() {
        while (stackOne.size()!=1){
            stackTwo.push(stackOne.pop());
        }
        Integer top =  stackOne.pop();
        stackTwo.push(top);
        while (stackTwo.size()!=0){
            stackOne.push(stackTwo.pop());
        }
        return top;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackOne.empty();
    }
}




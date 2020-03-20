import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 刘佳昇
 * @Date 2020/3/8 16:28
 */

public class leetcode面试题59II队列的最大值 {

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(3);
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(1);
        System.out.println(maxQueue.pop_front());

        System.out.println(maxQueue.max_value());

    }

}


class MaxQueue {

    Queue<Integer> queue = new LinkedList<Integer>();
    LinkedList<Integer> max = new LinkedList<Integer>();

    public MaxQueue() {

    }

    public int max_value() {
        if (max.size() == 0) {
            return -1;
        } else {

            return max.get(0);
        }
    }

    public void push_back(int value) {
        queue.offer(value);
        if (max.size() == 0) {
            max.add(value);
        } else {
            if (value > max.get(max.size() - 1)) {
                for (int i = 0; i < max.size(); i++) {
                    if (max.get(i)<value){
                        max.remove(i);
                        i--;
                    }
                }
                max.add(value);
            }else {
                max.add(value);
            }
        }
    }

    public int pop_front() {

        if (queue.size()!=0){
            if (max.size()!=0&&queue.peek().equals(max.get(0))){
                max.remove(0);
            }
            return queue.poll();
        }else {
            return -1;
        }


    }
}
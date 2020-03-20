/**
 * @author 刘佳昇
 * @Date 2020/2/25 20:45
 */

public class leetcode122买卖股票的最佳时机II {
    public static void main(String[] args) {
        int [] prices = {7,6,5,4,3,2,1};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int in = 0;
        int out = 1;
        int sum = 0;
        int lastDay = 0;
        int sumItem = 0;
        while (in <prices.length && out<prices.length){
            if (prices[lastDay]>prices[out]){
                //亏了
                in = out;
                lastDay = in;
                //重置天数
                out++;
                //下一天
                sum+=sumItem;
                //把此次的收益记下来
                sumItem=0;
                //重置此次的收益
            }else {
                //赚了
                sumItem = prices[out]-prices[in];
                //重新计算这次赚了多少钱
                lastDay = out;
                //今天就是明天的昨天
                out++;
                //下一天
                if (out==prices.length){
                    //假如明天是世界末日（明天没有东西了，投资结束了），
                    sum+=sumItem;
                    //赶紧把这次收益记下来
                }
            }

        }

        return sum;
    }

}

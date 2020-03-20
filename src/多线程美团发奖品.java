import java.util.Scanner;

/**
 * @author 刘佳昇
 * @Date 2019/10/16 16:01
 */

public class 多线程美团发奖品 {

    static ReviewEncourage reviewEncourage ;

    public static void MainMT1MT1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        多线程美团发奖品.reviewEncourage = new ReviewEncourage(num);
        new Thread(new ThreadDemo()).start();
        new Thread(new ThreadDemo()).start();
        new Thread(new ThreadDemo()).start();

    }
}

class ThreadDemo implements Runnable{

    @Override
    public void run() {
        synchronized (多线程美团发奖品.reviewEncourage){
            while (多线程美团发奖品.reviewEncourage.temp<= 多线程美团发奖品.reviewEncourage.n){
                if (多线程美团发奖品.reviewEncourage.temp%2!=0){
                    多线程美团发奖品.reviewEncourage.bonus(new PrizePool("A"));
                }else {
                    if (多线程美团发奖品.reviewEncourage.flag){
                        多线程美团发奖品.reviewEncourage.coupon(new PrizePool("B"));
                        多线程美团发奖品.reviewEncourage.flag=false;
                    }else {
                        多线程美团发奖品.reviewEncourage.contribution(new PrizePool("C"));
                        多线程美团发奖品.reviewEncourage.flag=true;

                    }
                }

                多线程美团发奖品.reviewEncourage.temp++;
            }
        }
    }
}

class ReviewEncourage {

    volatile int n;
    volatile int temp=1;
    volatile boolean flag = true;  //true 打印B  false 打印C
    public ReviewEncourage(int n) {
        this.n = n;
    }      // 构造函数,n为中奖用户


    public void bonus(PrizePool prizePool) {
        if (prizePool.input.equals("A")) {
            prizePool.send(prizePool.input);
        }
    }  // 仅能打印A，表示发放积分

    public void coupon(PrizePool prizePool) {
        if (prizePool.input.equals("B")) {
            prizePool.send(prizePool.input);
        }
    }  // 仅能打印B，表示发放优惠券

    public void contribution(PrizePool prizePool) {
        if (prizePool.input.equals("C")) {
            prizePool.send(prizePool.input);
        }
    }  // 仅能打印C，表示发放贡献值

}

//PrizePool类仅有一个send方法，实现如下：

class PrizePool {
    volatile String input;

    public PrizePool(String input) {
        this.input = input;
    }

    public void send(String input) {

        System.out.print(input);

    }

}
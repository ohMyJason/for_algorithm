import java.util.ArrayList;

/**
 * @author 刘佳昇
 * @Date 2019/10/15 2:01
 */

public class 生产者消费者2 {

    static ArrayList<String> content =  new ArrayList<String>();
    static int i = 0;




    public static void main(String[] args) {
        new Thread(new Producter()).start();
        new Thread(new Producter()).start();
        new Thread(new Producter()).start();
        new Thread(new Costomer()).start();

    }
}

 class Producter implements Runnable{
    @Override
    public void run() {
        synchronized (生产者消费者2.content){
            while (true){
                生产者消费者2.content.add("面包"+ 生产者消费者2.i++);
                System.out.println(Thread.currentThread().getName()+"--生产啦");
                System.out.println("容器内还剩："+ 生产者消费者2.content.toString());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                生产者消费者2.content.notifyAll();
                try {
                    生产者消费者2.content.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

 class Costomer implements Runnable{
    @Override
    public void run() {
        synchronized (生产者消费者2.content){
            while (true){
                if (生产者消费者2.content.size()==0){
                    try {
                        生产者消费者2.content.notifyAll();
                        生产者消费者2.content.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    生产者消费者2.content.remove(生产者消费者2.content.size()-1);
                    System.out.println("消费者 消费");
                    System.out.println("容器内还剩："+ 生产者消费者2.content.toString());
                    生产者消费者2.content.notifyAll();

                    try {
                        生产者消费者2.content.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }



                }

            }
        }
    }
}
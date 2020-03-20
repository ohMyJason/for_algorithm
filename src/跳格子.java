import java.util.Scanner;

/**
 * @author 刘佳昇
 * @Date 2019/10/18 19:46
 */

public class 跳格子 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            System.out.println(new 跳格子().palouti(n));
        }
    }

    public int palouti(int n){
        if (n==1||n==2){
            return n;
        }

        return palouti(n-1)+palouti(n-2);
    }
}

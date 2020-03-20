import java.math.BigDecimal;

/**
 * @author 刘佳昇
 * @Date 2020/1/19 20:57
 */

public class testClass {

    public static void main(String[] args) {




        String s = "α/▶▶/";

        System.out.println(s);
        double q = sum(2.2f,2.2);




        if (q==4.4){
            System.out.println("==");
        }else {
            System.out.println("!=");
        }



        System.out.println(q);

    }


    static double sum(float a,double b){
        //这是计算a+b
        double c = a+b;

        return c;
    }

}

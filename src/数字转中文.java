import java.util.Scanner;
import java.util.regex.Pattern;

public class 数字转中文 {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String num = sc.next();
        sc.close();

        if (num.length()==6){
            test(num.substring(0,2));
            System.out.print("万");
            test(num.substring(2,6));
        }else {

            test(num);
        }

//        System.out.println(new 数字转中文().witchWei(7));
//        System.out.println(new 数字转中文().witchNum(''));

    }

    public static  void test(String num){
        StringBuilder str = new StringBuilder();
        if (Pattern.compile("^-?[1-9]\\d*$").matcher(num).find()){
            int length = num.length();
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i)!='0'){
                    str.append(witchNum(num.charAt(i))).append(witchWei(length-i));
                }else {
                    if (i!=num.length()-1){
                        if (str.charAt(str.length()-1)!='零'){
                            str.append("零");
                        }
                    }

                }
            }
            System.out.println(str);

        }else {
            System.out.println("输入错误");
        }
    }

    public static String witchWei(int i ){

        if (i<=6&&i>=1){
            switch (i){
                case 1:{
                    return "";
                }
                case 2:{
                    return "十";
                }
                case 3:{
                    return "百";
                }
                case 4:{
                    return "千";
                }
                case 5:{
                    return "万";
                }
                case 6:{
                    return "十万";
                }
            }
        }else {
            return "-1";
        }
        return null;
    }//判断此时该输出什么


    public static String witchNum(char c){
        switch (c){
            case '0':
                return "";
            case '1':
                return "一";
            case '2':
                return "二";
            case '3':
                return "三";
            case '4':
                return "四";
            case '5':
                return "五";
            case '6':
                return "六";
            case '7':
                return "七";
            case '8':
                return "八";
            case '9':
                return "九";
            default:
                return "-1";
        }
    }
}



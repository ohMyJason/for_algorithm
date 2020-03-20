import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IP黑名单判断 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static boolean CheckBlackList(String userIP, String blackIP) {
        String[] userIpItems = userIP.split("\\.");
        String ym = blackIP.split("/")[1];   //掩码
        String[] blackIpItem = blackIP.split("/")[0].split("\\.");
        for (int i = 0; i <userIpItems.length ; i++) {
            userIpItems[i] = toBati(userIpItems[i]);
        }
        for (int i = 0; i < blackIpItem.length ; i++) {
            blackIpItem[i] = toBati(blackIpItem[i]);
        }

        StringBuilder uip = new StringBuilder(); //存储用户的二进制ip
        StringBuilder bip = new StringBuilder();  //存储黑名单的二进制ip

        for (String item :userIpItems){
            uip.append(item);
        }

        for (String item :blackIpItem){
            bip.append(item);
        }

        for (int i = 0; i <  Integer.parseInt(ym); i++) {
            if (uip.charAt(i) != bip.charAt(i)){
                return false;
            }
        }
        return true;

    }

    static String toBati(String item){  //将十进制转成8位的二进制
        String two = Integer.toBinaryString(Integer.parseInt(item));
        if (two.length()<8){
            int len = two.length();
            for (int i = 0; i < 8-len; i++) {
                two="0"+two;
            }
        }
        return two;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;

        String _userIP;
        try {
            _userIP = in.nextLine();
        } catch (Exception e) {
            _userIP = null;
        }

        String _blackIP;
        try {
            _blackIP = in.nextLine();
        } catch (Exception e) {
            _blackIP = null;
        }

        res = CheckBlackList(_userIP, _blackIP);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author 刘佳昇
 * @Date 2020/2/3 7:08
 */

public class URLTest2 {

    public static void main(String args[]) throws Exception {
        while (true){

            getSource("https://item.jd.com/40349168210.html");
        }
    }

    public static void  getSource(String urlStr){
        try {
            URL url = new URL(urlStr);
            InputStream in =url.openStream();
            InputStreamReader isr = new InputStreamReader(in,"GBK");
            BufferedReader bufr = new BufferedReader(isr);
            String str;
            boolean findFlag = false;
            while ((str = bufr.readLine()) != null) {
                if (findKeyWord(str,"到货通知")){
                    System.out.println(str);
                    findFlag =true;
                }
            }
            if (findFlag){
                System.out.println("找到");
            }else {
                System.out.println("未找到");
            }
            bufr.close();
            isr.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  static boolean findKeyWord(String string,String keyWord){
        int count = 0;
        int index = 0;
        while ((index=string.indexOf(keyWord,index)) != -1){
            index = index+keyWord.length();
            count++;

        }


        return count>0;

    }
}

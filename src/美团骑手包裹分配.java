import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 刘佳昇
 * @Date 2019/10/16 16:25
 */

/**
 * 美团骑手包裹区间分组
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 8192KB；其他语言 532480KB
 * 题目描述：
 * 2110年美团外卖火星第3000号配送站点有26名骑手，分别以大写字母A-Z命名，因此可以称呼这些骑手为黄家骑士特工A，黄家骑士特工B…黄家骑士特工Z，某美团黑珍珠餐厅的外卖流水线上会顺序产出一组包裹，美团配送调度引擎已经将包裹分配到骑手，并在包裹上粘贴好骑手名称，如RETTEBTAE代表一组流水线包裹共9个，同时分配给了名字为A B E R T的5名骑手。请在不打乱流水线产出顺序的情况下，把这组包裹划分为尽可能多的片段，同一个骑手只会出现在其中的一个片段，返回一个表示每个包裹片段的长度的列表。
 *
 * 输入
 * 输入数据只有一行，为一个字符串(不包含引号)，长度不超过1000，只包含大写字母'A'到'Z'，字符之间无空格。
 *
 * 输出
 * 输出每个分割成片段的包裹组的长度，每个长度之间通过空格隔开
 *
 *
 * 样例输入
 * MPMPCPMCMDEFEGDEHINHKLIN
 * 样例输出
 * 9 7 8
 *
 * 提示
 * 划分结果为 MPMPCPMCM, DEFEGDE, HINHKLIN。
 * 每个骑手最多出现在一个片段中。
 * 像 MPMPCPMCMDEFEGDE, HINHKLIN 的划分是错误的，因为划分的片段数较少。
 */
public class 美团骑手包裹分配 {

    static ArrayList<Integer>  res = new ArrayList<>();
    static int begin = 0;
    static int end = 0;
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();

        String str = "MPMPCPMCMDEFEGDEHINHKLIN";
        while (end<str.length()){
            Solution(new StringBuilder(str));
        }
    }

    public static void Solution(StringBuilder str ){


        StringBuilder tempStr = new StringBuilder(str.substring(begin,end));
        for (int s = begin; s < str.length(); s++) {
            if (ifExit(tempStr,str.charAt(s))){
                end = s;
                tempStr = new StringBuilder(str.substring(begin,s+1));
            }else {
                tempStr = new StringBuilder(str.substring(begin,s+1));
            }
        }
    }

    public static boolean ifExit(StringBuilder a,char target ){
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i)==target){
                return true;
            }
        }
        return false;
    }

}

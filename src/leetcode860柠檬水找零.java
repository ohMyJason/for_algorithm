import java.util.HashMap;

/**
 * @author 刘佳昇
 * @Date 2020/2/26 20:49
 */

public class leetcode860柠檬水找零 {

    public static void main(String[] args) {
        int [] bills = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
    }
    public static boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) {
            return false;
        }

        if (bills.length == 0) {
            return true;
        }
        HashMap<Integer, Integer> pkg = new HashMap<>();
        pkg.put(5,0);
        pkg.put(10,0);

        for (int bill : bills) {
            if (bill == 5) {
                pkg.put(5, pkg.get(5) + 1);
            }
            if (bill == 10) {
                if (pkg.get(5) > 0) {
                    pkg.put(5, pkg.get(5) - 1);
                    pkg.put(10, pkg.get(10) + 1);
                } else {
                    return false;
                }
            }
            if (bill == 20) {
                if (pkg.get(10) > 0) {
                    if (pkg.get(5) > 0) {
                        pkg.put(5, pkg.get(5) - 1);
                        pkg.put(10, pkg.get(10) - 1);
                    } else {
                        return false;
                    }
                } else {
                    if (pkg.get(5) >= 3) {
                        pkg.put(5, pkg.get(5) - 3);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 刘佳昇
 * @Date 2020/3/3 9:22
 */

public class leetcode中等面试题1622兰顿蚂蚁 {

    public static void main(String[] args) {
        System.out.println(printKMoves(534));
    }

    public static List<String> printKMoves(int K) {
        if (K == 0) {
            ArrayList<String> s = new ArrayList<>();
            s.add("R");
            return s;
        }
        int[] position = new int[2];
        //默认网格全白
        int dr = 1; //0 上 1 右 2 下 3 左
        int xmin = 0, xmax = 0, ymin = 0, ymax = 0; //地图的大小
        HashSet<String> black = new HashSet<>(); //存储网格


        for (int i = 0; i < K; i++) {
            String p = (position[0] + "," + position[1]);
            if (black.contains(p)) { //黑
                black.remove(p);
                dr = turn(false, dr);
                move(position, dr);
            } else {
                black.add(p);
                dr = turn(true, dr);
                move(position, dr);
            }
            if (position[0] < xmin) {
                xmin = position[0];
            }
            if (position[0] > xmax) {
                xmax = position[0];
            }
            if (position[1] < ymin) {
                ymin = position[1];
            }
            if (position[1] > ymax) {
                ymax = position[1];
            }
        }

        ArrayList<String> map = new ArrayList<>();
        for (int i = ymax; i >= ymin; i--) {
            String col = "";
            for (int j = xmin; j <= xmax; j++) {
                if (i == position[1] && j == position[0]) {
                    if (dr == 0) {
                        col += "U";
                    } else if (dr == 1) {
                        col+="R";
                    } else if (dr == 2) {
                        col+="D";
                    } else if (dr == 3) {
                        col+="L";
                    }
                } else {
                    if (black.contains((j + "," + i))) {
                        col += "X";
                    } else {
                        col += "_";
                    }
                }
            }
            map.add(col);
        }
        return map;
    }

    public static int turn(boolean t, int d) {  //true 右转，false 左转
        if (t) {
            d++;
            if (d > 3) {
                d = 0;
            }
        } else {
            d--;
            if (d < 0) {
                d = 3;
            }
        }
        return d;
    }

    public  static  void move(int[] position, int dr) {
        if (dr == 0) {
            position[1]++;
        } else if (dr == 1) {
            position[0]++;
        } else if (dr == 2) {
            position[1]--;
        } else if (dr == 3) {
            position[0]--;
        }

    }

}

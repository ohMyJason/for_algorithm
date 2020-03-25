import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author 刘佳昇
 * @Date 2020/3/25 20:33
 */

public class leetcode1030距离顺序排列矩阵单元格 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(allCellsDistOrder(2, 2, 0, 1)));
    }
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        ArrayList<int[]> pl = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int[] p = new int[2];
                p[0] = i;
                p[1] = j;
                pl.add(p);
            }
        }
        Collections.sort(pl, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dr1 = Math.abs(o1[0]-r0)+Math.abs(o1[1]-c0);
                int dr2 = Math.abs(o2[0]-r0)+Math.abs(o2[1]-c0);
                return dr1-dr2;
            }
        });
        return pl.toArray(new int[0][]);
    }
}



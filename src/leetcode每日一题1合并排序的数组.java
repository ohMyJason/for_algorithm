import java.util.Arrays;

/**
 * @author 刘佳昇
 * @Date 2020/3/3 4:44
 */

public class leetcode每日一题1合并排序的数组 {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        int m = 3;
        int n = 3;
        merge(A, m, B, n);
        System.out.println(Arrays.toString(A));

    }

    public static void merge(int[] A, int m, int[] B, int n) {
        if (m == 0 && n == 1) {
            A[0] = B[0];
        } else if (m == 1 && n == 0) {

        } else {

            int Ai = 0;
            int Bi = 0;
            while (Ai < A.length && Bi < B.length) {
                if (B[Bi] < A[Ai] || Ai >= m ) {
                    move(A, Ai);
                    A[Ai] = B[Bi];
                    Bi++;
                    m++;
                }
                Ai++;
            }
        }

    }

    public static void move(int[] A, int n) {
        for (int i = A.length - 1; i >= n; i--) {
            A[i] = A[i - 1];
        }
    }
}

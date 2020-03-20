import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class 携程员工匹配 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static boolean BestMatch(int[] LimitArray, int[][] DegMatrix) {  //限制数  DeMartix每个员工的喜好

        if (LimitArray == null || LimitArray.length == 0) {
            return false;
        } else if (DegMatrix == null || DegMatrix.length == 0) {
            return false;
        }

        int sum = 0; //记录总数
        boolean[] visit = new boolean[DegMatrix.length];

        for (int i = 0; i < LimitArray.length; i++) {  //遍历区域
            for (int j = 0; j < LimitArray[j]; j++) {  //根据区域限制数插入
                sum += findMax(i, DegMatrix, visit);
            }
        }
        System.out.println(sum);
        return true;

    }

    static int findMax(int i, int[][] Deg, boolean[] visit) {
        int temp = Deg[0][i];
        int index = 0;
        for (int j = 0; j <Deg.length; j++) {
            if (temp < Deg[j][i]) {
                if (!visit[j]){  //如果该员工没访问过
                    temp = Deg[j][i];
                    index = j;
                }
            }
        }
        visit[index] = true;

        return temp;
    }//找到对某个区域喜好程度最大的员工

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean res;

        int _LimitArray_size = 0;
        int _DegMatrix_rows = 0;
        int _DegMatrix_cols = 0;
        _DegMatrix_rows = Integer.parseInt(in.nextLine().trim());   //N
        _DegMatrix_cols = Integer.parseInt(in.nextLine().trim());  // M
        _LimitArray_size = _DegMatrix_cols;

        int[] _LimitArray = new int[_LimitArray_size];
        int _LimitArray_item;
        for (int _LimitArray_i = 0; _LimitArray_i < _LimitArray_size; _LimitArray_i++) {
            _LimitArray_item = Integer.parseInt(in.next().trim());
            _LimitArray[_LimitArray_i] = _LimitArray_item;
        }

        int[][] _DegMatrix = new int[_DegMatrix_rows][_DegMatrix_cols];
        for (int _DegMatrix_i = 0; _DegMatrix_i < _DegMatrix_rows; _DegMatrix_i++) {
            for (int _DegMatrix_j = 0; _DegMatrix_j < _DegMatrix_cols; _DegMatrix_j++) {
                _DegMatrix[_DegMatrix_i][_DegMatrix_j] = in.nextInt();

            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }

        res = BestMatch(_LimitArray, _DegMatrix);
//        System.out.println(String.valueOf(res ? 1 : 0));
    }
}

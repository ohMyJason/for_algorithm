import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class 递归走格子 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int sum = 0;
    static int DynamicPathPlanning(int[][] matrixGrid) {

        if (matrixGrid.length==0||matrixGrid==null){
            return  -1;
        }
        digui(matrixGrid[0].length-1,matrixGrid.length-1,matrixGrid);
        return sum;
    }

    static void digui(int i, int j,int[][] matrixGrid){
        if (i<0||j<0){
            return;
        }
        if (i==0&&j==0){
            sum++;
            return ;
        }
        if (matrixGrid[i][j]==1){
            return;
        }else {
            digui(i-1,j,matrixGrid);
            digui(i,j-1,matrixGrid);
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _matrixGrid_rows = 0;
        int _matrixGrid_cols = 0;
        _matrixGrid_rows = Integer.parseInt(in.nextLine().trim());
        _matrixGrid_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _matrixGrid = new int[_matrixGrid_rows][_matrixGrid_cols];
        for(int _matrixGrid_i=0; _matrixGrid_i<_matrixGrid_rows; _matrixGrid_i++) {
            for(int _matrixGrid_j=0; _matrixGrid_j<_matrixGrid_cols; _matrixGrid_j++) {
                _matrixGrid[_matrixGrid_i][_matrixGrid_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = DynamicPathPlanning(_matrixGrid);
        System.out.println(String.valueOf(res));

    }
}

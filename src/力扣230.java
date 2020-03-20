/**
 * @author 刘佳昇
 * @Date 2020/1/15 23:58
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * Definition for a binary tree node.
 * */



public class 力扣230 {

    ArrayList<Integer> integers = new ArrayList<>();


    public static void main(String[] args) {



    }

    public void digui(TreeNode root){
        if (root.left!=null){

            digui(root.left);
        }
        if (root.right!=null){

            digui(root.right);
        }
        integers.add(root.val);
    }

    public int kthSmallest(TreeNode root, int k) {
        digui(root);
        Collections.sort(integers);
        return integers.get(k);

    }

}

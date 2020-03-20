/**
 * @author 刘佳昇
 * @Date 2020/3/10 21:04
 */

public class leetcode543二叉树的直径 {

    public static void main(String[] args) {
        int [] a = {0,1,2,3,4,5,6};
        TreeNode root = creatTree(a,0);
        System.out.println(root);
    }
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res=1;
        digui(root);
        return res-1;
    }

    public int digui(TreeNode node){
        if (node==null){return 0;}
        int L = digui(node.left);
        int R = digui(node.right);
        res = Math.max(res,L+R+1);
        return Math.max(L,R)+1;
    }


    public static TreeNode creatTree(int [] a,int i){
        if (i<a.length){
            TreeNode node = new TreeNode(a[i]);
            node.left = creatTree(a,2*i+1);
            node.right = creatTree(a,2*i+2);
            return node;
        }else {
            return null;
        }

    }


}






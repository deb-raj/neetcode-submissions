/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
          
       if(p == null && q!=null){
        return false;
       }
       if(p!= null && q==null) {
        return false;
       }
       return check(p,q);

    }

    private boolean check(TreeNode p , TreeNode q) {
            if(p == null && q == null) {
            return true;
        }
         if(p == null && q!=null){
        return false;
       }
       if(p!= null && q==null) {
        return false;
       }
       if(p.val != q.val) {
        return false;
       }

        boolean left = check(p.left,q.left);

        if(left==false){
            return false;
        }
        boolean right = check(p.right, q.right);

        if(right == false) {
            return false;
        }
        return right && left;
    }

}

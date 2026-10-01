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

    int gMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        build(root);
        return gMax;
        
    }

    private int build(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int left = build(root.left);
        int right = build(root.right);

        left = Math.max(0,left);
        right = Math.max(0,right);

        int max = left + root.val + right;

        gMax = Math.max(max,gMax);

        return root.val + Math.max(left,right);

    }
}

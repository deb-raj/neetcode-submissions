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
    int Gmax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);

        return Gmax;
        
    }

    private int dfs(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        left = Math.max(0,left);
        right = Math.max(0,right);

        int currentPath = left + root.val + right;

        Gmax = Math.max(Gmax,currentPath);

        return root.val + Math.max(left,right);

    }
}

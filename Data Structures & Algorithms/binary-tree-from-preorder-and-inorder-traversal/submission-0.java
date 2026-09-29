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

    int preIndex=0;

    HashMap<Integer,Integer>map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        map = new HashMap<>();

        for(int i=0;i<inorder.length;i++) {

            map.put(inorder[i],i);
        }

        return build(0,inorder.length-1,preorder);
    }

    private TreeNode build(int lower,int upper , int[]preorder) {

        if(lower > upper) {
            return null;
        }

        int root = preorder[preIndex];

        preIndex++;

        int index = map.get(root);

        TreeNode rootNode = new TreeNode(root);

        rootNode.left = build(lower,index-1,preorder);

        rootNode.right = build(index+1,upper,preorder);

        return rootNode;
    }
}

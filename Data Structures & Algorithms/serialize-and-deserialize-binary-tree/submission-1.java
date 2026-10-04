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

public class Codec {
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        
        StringBuilder sb = new StringBuilder();
        build(root,sb);

        return sb.toString();
        

    }
    private void build(TreeNode root,StringBuilder sb) {


        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val+",");
        build(root.left,sb);
        build(root.right,sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        
        
        String [] tokens = data.split(",");

       return build(tokens);
    }

    private TreeNode build(String[] tokens) {

        String token = tokens[index];
        index++;

        if(token .equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(token));

       node.left = build(tokens);
       node.right = build(tokens);

       return node;
    }
}

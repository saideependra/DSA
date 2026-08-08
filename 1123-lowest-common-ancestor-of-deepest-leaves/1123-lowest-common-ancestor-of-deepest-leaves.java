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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return fun(root).node;
    }
    private Pair fun(TreeNode node){
        if(node == null)return new Pair(0,null);

        Pair left = fun(node.left);
        Pair right = fun(node.right);

        if(left.depth == right.depth){
            return new Pair(left.depth+1,node);
        }
        if(left.depth>right.depth){
            return new Pair(left.depth+1,left.node);
        }else{
            return new Pair(right.depth+1,right.node);
        }

    }

    private static class Pair{
        int depth;
        TreeNode node;
        Pair(int depth,TreeNode node){
            this.depth = depth;
            this.node = node;
        }
    }
}
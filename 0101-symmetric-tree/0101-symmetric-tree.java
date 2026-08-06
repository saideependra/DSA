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
    public boolean isSymmetric(TreeNode root) {
        return fun(root.left,root.right);
    }
    public boolean fun(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(q.val != p.val) return false;

        boolean r1 = fun(p.left,q.right);
        boolean r2 = fun(q.left,p.right);
        
        return (r1 && r2);
    }
}
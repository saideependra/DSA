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
    public HashMap<Integer,Integer> map = new HashMap<>();
    public int postIdx = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        postIdx = postorder.length-1;

        return build(postorder, 0, inorder.length -1);
    }
    public TreeNode build(int postorder[],int left,int right){
        if(left > right) return null;

        int root_val = postorder[postIdx];

        postIdx--;
        

        TreeNode node = new TreeNode(root_val);
        int index = map.get(root_val);

        node.right = build(postorder,index+1,right);
        node.left = build(postorder,left,index-1);

        return node;
    }
}
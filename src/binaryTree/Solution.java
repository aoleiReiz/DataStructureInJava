package binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    private boolean hasPathSum(TreeNode node, int curSum, int sum){
        if (node.left == null && node.right == null){
            return curSum + node.val == sum;
        }
        curSum += node.val;

        if (node.left != null && node.right != null){
            return hasPathSum(node.left, curSum, sum) || hasPathSum(node.right, curSum, sum);
        }else if (node.left != null){
            return hasPathSum(node.left, curSum, sum);
        }else{
            return hasPathSum(node.right, curSum, sum);
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root)
            return false;
        return hasPathSum(root, 0, sum);
    }

    public int maxDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        int left_ans = maxDepth(root.left);
        int right_ans = maxDepth(root.right);
        return Math.max(left_ans, right_ans) + 1;
    }

    private boolean isSymmetricHelper(TreeNode node1, TreeNode node2){
        if (null == node1 && null == node2){
            return true;
        }else if (node1 != null && node2 != null) {
            return node1.val == node2.val && isSymmetricHelper(node1.left,node2.right)&&isSymmetricHelper(node1.right,node2.left);
        }else{
            return false;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root,root);
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);


        node1.left = node2;


        Solution s = new Solution();
        System.out.println(s.hasPathSum(node1, 1));
    }


    public int minDepth(TreeNode root) {
        if (null == root){
            return 0;
        }
        if (root.right == null && root.left == null){
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null){
            min_depth = Math.min(minDepth(root.left),min_depth);
        }
        if (root.right != null){
            min_depth = Math.min(minDepth(root.right),min_depth);
        }
        return min_depth;
    }

}

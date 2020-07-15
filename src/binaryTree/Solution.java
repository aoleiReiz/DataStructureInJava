package binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root)
            return false;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> queueSum = new ArrayDeque<>();
        queue.add(root);
        queueSum.add(root.val);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                int curSum = queueSum.remove();
                if (null == node.left && null == node.right){
                    if (curSum == sum){
                        return true;
                    }
                }
                if (null != node.left){
                    int tempSum = curSum + node.left.val;
                    queueSum.add(tempSum);
                    queue.add(node.left);
                }
                if (null != node.right){
                    int tempSum = curSum + node.right.val;
                    queueSum.add(tempSum);
                    queue.add(node.right);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.right = node9;

        Solution s = new Solution();
        System.out.println(s.hasPathSum(node1, 22));
    }
}

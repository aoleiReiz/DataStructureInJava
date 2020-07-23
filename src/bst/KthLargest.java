package bst;

import sun.reflect.generics.tree.Tree;

public class KthLargest {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        int cnt;
        public TreeNode(int x){
            val = x;
            cnt = 1;
        }
    }

    private TreeNode root;
    private int k;

    public KthLargest(int _k, int[] nums) {
        k = _k;
        for (int i : nums) {
            initAdd(i);
        }
    }


    private TreeNode addElement( TreeNode node, int val){
        if (node == null){
            return new TreeNode(val);
        }
        node.cnt ++;
        if (val >= node.val){
            node.right = addElement(node.right, val);
        }else if (val < node.val){
            node.left = addElement(node.left, val);
        }
        return node;
    }

    private int findNumber(TreeNode node, int k){
        int m = node.cnt;
        if (null != node.right){
            m = node.right.cnt + 1;
        }
        if (m == k){
            return node.val;
        }
        if (m > k){
            return findNumber(node.right, k);
        }else{
            return findNumber(node.left, k - m);
        }
    }

    private void initAdd(int val){
        root = addElement(root, val);
    }

    public int add(int val) {
        root = addElement(root, val);
        return findNumber(root,k);
    }
}

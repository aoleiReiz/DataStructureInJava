package bst;

public class Solution {


    boolean isValidBSTHelper(TreeNode node, Integer lower, Integer upper){
        if (null == node){
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!isValidBSTHelper(node.right, val,upper)) return false;
        if (!isValidBSTHelper(node.left,lower,val)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }
}

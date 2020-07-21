package bst;

public class BST<E extends Comparable<E>> {
    public class TreeNode{
        E val;
        TreeNode left;
        TreeNode right;

        public TreeNode(E _val){
            val = _val;
            left = null;
            right = null;
        }
    }

    public TreeNode searchBST(TreeNode root, E val) {
        if (null == root){
            return null;
        }
        if (root.val.compareTo(val) == 0){
            return root;
        }else if (root.val.compareTo(val) < 0){
            return searchBST(root.right, val);
        }else{
            return searchBST(root.left, val);
        }
    }


    private TreeNode add(TreeNode node, E val){
        if (null == node){
            return new TreeNode(val);
        }
        if (node.val.compareTo(val) > 0){
            node.right = add(node.right, val);
        }else if (node.val.compareTo(val) < 0) {
            node.left = add(node.left, val);
        }
        return node;
    }
    public TreeNode insertIntoBST(TreeNode root, E val) {
        return add(root, val);
    }


    public TreeNode minimun(TreeNode root){
        if (null == root){
            return null;
        }
        if (root.left == null){
            return root;
        }else{
            return minimun(root.left);
        }

    }


}

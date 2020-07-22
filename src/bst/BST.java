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


    public TreeNode minimum(TreeNode root){
        if (null == root){
            return null;
        }
        if (root.left == null){
            return root;
        }else{
            return minimum(root.left);
        }

    }

    public TreeNode maximum(TreeNode root){
        if (null == root){
            return null;
        }
        if (root.right == null){
            return root;
        }else{
            return maximum(root.right);
        }
    }

    private TreeNode removeMinHelper(TreeNode node){
        if (node.left == null){
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMinHelper(node.left);
        return node;
    }
    public TreeNode removeMin(TreeNode root){
        return removeMinHelper(root);
    }

    private TreeNode removeMaxHelper(TreeNode node){
       if (node.right == null){
           TreeNode leftNode = node.left;
           node.left = null;
           return leftNode;
       }
       node.right = removeMax(node.right);
       return node;
    }
    public TreeNode removeMax(TreeNode root){
        return removeMinHelper(root);
    }


    public TreeNode remove(TreeNode root,E e){
        if (root == null){
            return null;
        }
        if (e.compareTo(root.val) < 0){
           root.left = remove(root.left, e);
           return root;
        }else if (e.compareTo(root.val) > 0){
            root.right = remove(root.right, e);
            return root;
        }else{
            if (root.left == null){
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }
            if (root.right == null){
                TreeNode left = root.left;
                root.left = null;
                return left;
            }
            TreeNode successor = minimum(root.right);
            successor.right = removeMin(root.right);
            successor.left = root.left;
            root.left = root.right = null;
            return successor;
        }
    }

}

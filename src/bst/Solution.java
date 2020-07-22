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

    private TreeNode add(TreeNode node, int val){
        if (null == node){
            return new TreeNode(val);
        }
        if(val < node.val)
            node.left = add(node.left, val);
        if(val > node.val)
            node.right = add(node.right, val);
        return node;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return add(root, val);
    }

    public TreeNode maximum(TreeNode node){
        if (node.right == null){
            return node;
        }
        return maximum(node.right);
    }
    public TreeNode minimum(TreeNode node){
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }
    public TreeNode removeMin(TreeNode node){
        if (node == null){
            return null;
        }
        if (node.left == null){
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    public TreeNode removeMax(TreeNode node){
        if (node == null){
            return null;
        }
        if (node.right == null){
            TreeNode leftNode = node.left;
            node.left = null;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root){
            return null;
        }
        if (root.val > key){
           root.left = deleteNode(root.left, key);
           return root;
        }else if (root.val < key){
            root.right = deleteNode(root.right, key);
            return root;
        }else{
            if (root.left == null){
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }
            if (root.right == null){
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }
            TreeNode successor = minimum(root.right);
            successor.right = removeMin(root.right);
            successor.left = root.left;
            root.left = root.right = null;
            return successor;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (cur != null){
            if (cur.val < p.val && cur.val < q.val){
                cur = cur.right;
            }else if (cur.val == p.val && cur.val == q.val){
                return cur;
            }else if (cur.val > p.val && cur.val > q.val){
                cur = cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 1; j <= k && i + j < nums.length; j++) {
                if (t <= 0){
                    return true;
                }
                if ((nums[i] > 0 && nums[i+j] > 0)||(nums[i] < 0 && nums[i+j] < 0)){
                    if(Math.abs(nums[i] - nums[i+j]) <= t){
                        return true;
                    }
                }else{
                    if (t < Math.abs(nums[i]) || t < Math.abs(nums[i+j])){
                        return false;
                    }
                    if (t - Math.abs(nums[i])-Math.abs(nums[i+j]) >=0){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private int depth(TreeNode node, int h){
        if (node == null){
            return h;
        }
        int leftHeight = depth(node.left, h+1);
        int rightHeight = depth(node.right, h + 1);
        return Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        if (null == root){
            return true;
        }
        int leftHeight = depth(root.left, 0);
        int rightHeight = depth(root.right, 0);

        if (Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }else{
            boolean left = isBalanced(root.left);
            boolean right = isBalanced(root.right);
            return left && right;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}

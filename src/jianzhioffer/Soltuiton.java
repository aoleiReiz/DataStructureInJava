package jianzhioffer;

public class Soltuiton {
    public int findRepeatNumber(int[] nums) {
        int []count = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            count[i]++;
            if (count[i] > 1)
                return i;
        }
        return -1;
    }

    public char firstUniqChar(String s) {
        int []count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)- 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)- 'a'] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2){
        if (null == node1 && node2 == null){
            return true;
        }else if (null == node1 || node2 == null){
            return false;
        }else{
            return node1.val == node2.val && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if (null == root)
            return false;
        return isSymmetric(root,root);
    }


    public int maxDepth(TreeNode root) {
        if (null == root){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public int kthLargest(TreeNode root, int k) {
        curK = k;
        dfs(root);
        return res;
    }
    private int curK;
    private int res;
    private void dfs(TreeNode root){
        if (null == root){
            return;
        }
        dfs(root.right);
        curK -- ;
        if (curK == 0){
            res = root.val;
        }
        dfs(root.left);
    }
}

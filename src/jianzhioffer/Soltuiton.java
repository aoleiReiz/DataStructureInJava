package jianzhioffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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



    public int[] levelOrder(TreeNode root) {
        if (null == root){
            return new int[0];
        }
        List<Integer>list = new ArrayList<>();
        Queue<TreeNode>queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        int []ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>>ret = new ArrayList<>();
        if (null == root){
            return ret;
        }
        Queue<TreeNode>queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer>list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            ret.add(list);
        }

        return ret;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>>ret = new ArrayList<>();
        if (null == root){
            return ret;
        }
        Queue<TreeNode>queue = new ArrayDeque<>();
        queue.add(root);

        int k = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer>list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            if (k % 2 == 0)
                ret.add(list);
            else {
                List<Integer>temp = new ArrayList<>();
                for (int i = list.size() - 1; i >= 0 ; i--) {
                    temp.add(list.get(i));
                }
                ret.add(temp);
            }
            k++;
        }

        return ret;
    }

    public int fib(int n) {
        if (n <= 1)
            return n;
        int prev = 0 , cur = 1;
        for (int i = 2; i <= n ; i++) {
            int temp = prev + cur;
            prev = cur;
            cur = temp;
        }
        return cur;
    }

    public int numWays(int n) {
        if(n <= 1){
            return 1;
        }
        int prev = 1, cur = 1;
        for (int i = 2; i<=n; i++){
            int t = (prev + cur)%1000000007;
            prev = cur;
            cur = t;
        }
        return cur;
    }

    public int maxSubArray(int[] nums) {
        int []dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        int curMax = dp[0];
        for (int i = 1; i < nums.length ; i++) {
            if (dp[i] > curMax){
                curMax = dp[i];
            }
        }
        return curMax;
    }

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //同时可以从右 从上
                if (i - 1 >= 0 && j - 1 >= 0){
                    grid[i][j] = Math.max(grid[i-1][j],grid[i][j-1]) + grid[i][j];
                }else if (i - 1 >= 0){
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }else if (j - 1 >= 0){
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
            }
        }
        return grid[m-1][n-1];
    }

    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }


    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int j = s.length()-1;
        while (j >= 0) {
            while (j >= 0 && s.charAt(j) == ' ')
                j--;
            if (j < 0)
                break;
            int i = j-1;
            while (i>= 0 && s.charAt(i) != ' ')
                i--;
            sb.append(s, i+1, j+1);
            sb.append(" ");
            j = i-1;
        }
        return sb.length()> 0 ? sb.substring(0, sb.length() - 1): "";
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0,n);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p, q);
        }
        else if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (right == null &&left == null){
            return null;
        }else if (left == null && right != null){
            return right;
        }else if (left != null && right == null){
            return left;
        }else{
            return root;
        }

    }

}

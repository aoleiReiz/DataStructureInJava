package interviewquestion;

import java.util.*;

public class InterviewQuestionSolution {

    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0){
            return 0;
        }
        int []dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
        }
        int maxSequenceSum = nums[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > maxSequenceSum){
                maxSequenceSum = dp[i];
            }
        }
        return maxSequenceSum;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int []aux = new int[m];
        for (int i = 0; i < m; i++) {
            aux[i] = nums1[i];
        }
        int i = 0, j = 0, k = 0;
        while (i < m && j < n){
            if (aux[i] <= nums2[j]){
                nums1[k++] = aux[i++];
            }else{
                nums1[k++] = nums2[j++];
            }
        }
        while (i < m){
            nums1[k++] = aux[i++];
        }
        while (j < n){
            nums1[k++] = nums2[j++];
        }
    }

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0){
            return 0;
        }
        int ret = 0;
        int curMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > curMin){
                ret = Math.max(prices[i] - curMin, ret);
            }else{
                curMin = prices[i];
            }
        }

        return ret;
    }

    public boolean isPalindrome(String s) {
        if (null == s || s.length() <= 1){
            return true;
        }
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (Character.isLetterOrDigit(ci) && Character.isLetterOrDigit(cj)){
                if (ci != cj){
                    return false;
                }else{
                    i++;
                    j--;
                }
            }else if (!Character.isLetterOrDigit(ci) && !Character.isLetterOrDigit(cj)){
                i++;
                j--;
            }else if (!Character.isLetterOrDigit(ci)){
                i++;
            }else{
                j--;
            }
        }
        return true;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (null != root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
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
                ret.add(list);
            }
        }
        return ret;
    }

    public Node copyRandomList(Node head) {
        if (null == head){
            return null;
        }
        Map<Node,Node>map = new HashMap<>();
        Node p = head;
        while (p != null){
            if (!map.containsKey(p)){
                map.put(p, new Node(p.val));
            }
            p = p.next;
        }
        p = head;
        while ()


    }
}

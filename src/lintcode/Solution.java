package lintcode;

public class Solution {
    /*
     * @param num: An integer
     * @return: An integer
     */
    public int countOnes(int num) {
        // write your code here
        int count =0;
        String str = Integer.toBinaryString(num);
        char[] chararr = str.toCharArray();
        for(int i=0;i<chararr.length;i++){
            if(chararr[i]=='1'){
                count++;
            }
        }
        return count;
    }

    public ListNode reverse(ListNode head,ListNode prev){
        if(null == head){
            return prev;
        }
        ListNode p = head.next;
        head.next = prev;
        return reverse(p,head);
    }
    public ListNode reverse(ListNode head) {
        return reverse(head,null);
    }

    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]){
                return nums[i+1];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = s.countOnes(-2);
        System.out.println(n);
    }
}

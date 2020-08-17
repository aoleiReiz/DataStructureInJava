package algorithm.recurse;

public class RecurseSolution {


    public void reverseString(char[] s) {
        helper(0, s.length - 1, s);
    }

    private void helper(int start, int end, char [] s) {
        if (start >= end) {
            return;
        }
        // swap between the first and the last elements.
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;

        helper(start + 1, end - 1, s);
    }

    private ListNode swapPairs(ListNode prev, ListNode cur){
        if(prev == null || cur == null){
            return prev;
        }
        ListNode next = cur.next;
        cur.next = prev;
        if (next != null)
            prev.next = swapPairs(next, next.next);
        else
            prev.next = null;
        return cur;
    }
    public ListNode swapPairs(ListNode head) {
        if (null == head || head.next == null)
            return head;
        return swapPairs(head, head.next);
    }

    private ListNode reverseList(ListNode prev, ListNode cur){
        if (cur == null){
            return prev;
        }
        ListNode next = cur.next;
        cur.next = prev;

        return reverseList(cur, next);
    }
    public ListNode reverseList(ListNode head) {
        if(null == head || head.next == null)
            return head;
        return reverseList(null, head);
    }

    public int fib(int N) {
        if(N <= 1){
            return N;
        }
        int prev = 0, cur = 1;
        for (int i = 2; i <= N; i++) {
            int temp = prev + cur;
            prev = cur;
            cur = temp;
        }
        return cur;
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private int kthGrammer(String s, int i, int K){
        if (i < K){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) =='0'){
                    sb.append("01");
                }else{
                    sb.append("10");
                }
            }
            return kthGrammer(sb.toString(), i + 1, K);
        }else{
            return s.charAt(K-1) - '0';
        }
    }
    public int kthGrammar(int N, int K) {
        return kthGrammer("0",1,K);
    }

}

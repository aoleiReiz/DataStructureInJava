package bst;

public class TestBST {

    public static void main(String[] args) {
        int []nums = {4,5,8,2};
        Solution s = new Solution();
        KthLargest kthLargest = new KthLargest(3, nums);

        int []testNums = {3,5,10,9,4};
        for (int i : testNums){
            int x  = kthLargest.add(i);
            System.out.println(x);
        }

    }
}

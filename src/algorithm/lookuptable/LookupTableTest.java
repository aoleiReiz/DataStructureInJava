package algorithm.lookuptable;

import java.util.List;

public class LookupTableTest {

    public static void main(String[] args) {
        int []A = { 0, 1, -1};
        int []B = {-1, 1, 0};
        int []C = {0, 0, 1};
        int []D = {-1, 1, 1};
        Solution s = new Solution();
        int count = s.fourSumCount(A, B, C, D);
        System.out.println(count);
    }
}

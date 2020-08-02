package algorithm.lookuptable;

import java.util.List;

public class LookupTableTest {

    public static void main(String[] args) {
        int []nums = {1, 0, -1, 0, -2, 2};
        Solution s = new Solution();
        List<List<Integer>>lists = s.fourSum(nums,0);
        for (List<Integer> list : lists){
            for (int i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

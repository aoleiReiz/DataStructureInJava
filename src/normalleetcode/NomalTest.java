package normalleetcode;

import java.util.List;

public class NomalTest {

    public static void main(String[] args) {
        Solution s = new Solution();
        int []nums = {4,6,7,7};
        List<List<Integer>> lists = s.findSubsequences(nums);
        for (List<Integer> list : lists){
            System.out.println(list.toString());
        }
    }
}

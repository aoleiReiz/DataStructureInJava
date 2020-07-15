package algorithm.trackpackrecur;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    String [] strings = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private void letterCombinationsHelper(String digits, int index, String s, List<String>res){
        if (index == digits.length()){
            res.add(s);
            return ;
        }
        char c = digits.charAt(index);
        assert c >= '2' && c <= '9';
        String letters = strings[c - '0' - 1];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsHelper(digits,index+1, s + letters.charAt(i), res);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (null != digits && !"".equals(digits)) {
            letterCombinationsHelper(digits, 0, "", res);
        }
        return res;
    }

    private void combineHelper(int n, int k, int start, List<Integer>curList, List<List<Integer>>res){
        if (curList.size() == k){
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = start; i <= n && i <= ( n - (k - curList.size()) + 1); i++) {
            curList.add(i);
            combineHelper(n, k, i+1, curList, res );
            curList.remove(curList.size() - 1);
        }
        return;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>res = new ArrayList<>();
        combineHelper(n, k, 1,new ArrayList<>(),res);
        return res;
    }


    private void combinationSumHelper(int[] candidates, int target, int curSum, List<Integer>path, List<List<Integer>>res){

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>>lists = s.combine(4,2);
        for (List<Integer>list : lists){
            for (int i : list){
                System.out.print( i + " ");
            }
            System.out.println();
        }
    }
}

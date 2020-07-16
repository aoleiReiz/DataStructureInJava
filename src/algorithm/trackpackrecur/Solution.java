package algorithm.trackpackrecur;

import com.sun.org.apache.bcel.internal.generic.LUSHR;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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


    private void combinationSumHelper(int[] candidates,int target, int start, int curSum, List<Integer>path, List<List<Integer>>res){
        if (curSum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length && curSum + candidates[i] <= target; i++) {
            path.add(candidates[i]);
            combinationSumHelper(candidates, target, i,curSum + candidates[i], path, res);
            path.remove(path.size()-1);
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (null != candidates && candidates.length > 0) {
            Arrays.sort(candidates);
            combinationSumHelper(candidates, target, 0, 0, new ArrayList<>(), res);
        }
        return res;
    }


    private void combinationSum2Helper(int []candidates, int target, int start, int curSum,List<Integer>path, List<List<Integer>>res){
        if (curSum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length && curSum + candidates[i]<= target; i++) {
            if (i!=start && candidates[i] == candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            combinationSum2Helper(candidates, target, i+1, curSum + candidates[i], path, res);
            path.remove(path.size()-1);
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res = new ArrayList<>();
        if (null != candidates && candidates.length > 0){
            int sum = 0;
            for (int i = 0; i < candidates.length; i++) {
                sum += candidates[i];
            }
            if (sum >= target){
                Arrays.sort(candidates);
                combinationSum2Helper(candidates, target, 0, 0,new ArrayList<>(), res);
            }
        }
        return res;
    }


    private void subsetsHelper(int []nums, List<Integer>path, int start, List<List<Integer>>res){
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsHelper(nums, path, i+1, res);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        if (nums != null){
            subsetsHelper(nums, new ArrayList<>(), 0, res);
        }
        return res;
    }

    private void subsetsWithDupHelper(int []nums, List<Integer>path, int start, List<List<Integer>>res){
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            subsetsWithDupHelper(nums, path, i+1, res);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        if (nums != null){
            Arrays.sort(nums);
            subsetsWithDupHelper(nums, new ArrayList<>(), 0, res);
        }
        return res;
    }


    private void combinationSum3Helper(int n, int k, int cur, int start, List<Integer>path, List<List<Integer>>res){
        if (cur == n && path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 9 && cur + i <= n && k > path.size(); i++) {
            path.add(i);
            combinationSum3Helper(n, k, cur + i, i+1 ,path, res);
            path.remove(path.size()-1);
        }

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum3Helper(n, k, 0, 1, new ArrayList<>(), res);
        return res;
    }


    private void readBinaryWatchHelper(int []times, int start, int limit, int size, int cur, List<Integer>path ,List<Integer>res){
        if (path.size() == size){
            res.add(cur);
            return;
        }
        for (int i = start; i <times.length && cur + times[i] < limit && path.size() < size; i++) {
            path.add(times[i]);
            readBinaryWatchHelper(times, i+1, limit, size, cur + times[i], path, res);
            path.remove(path.size() -1 );
        }
    }
    public List<String> readBinaryWatch(int num) {
        int []hours = {1,2,4,8};
        int []minutes = {1,2,4,8,16,32};
        List<String>res = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        readBinaryWatchHelper(minutes, 0, 60, 2, 0, new ArrayList<>(),list);
        //时钟亮数目
        for (int hn = 0; hn <= num ; hn++) {
            int mn = num - hn;
            List<Integer>hourList = new ArrayList<>();
            readBinaryWatchHelper(hours, 0, 12, hn, 0, new ArrayList<>(),hourList);
            List<Integer>minuteList = new ArrayList<>();
            readBinaryWatchHelper(minutes, 0, 60, mn, 0, new ArrayList<>(),minuteList);
            for (int h : hourList){
                for (int m : minuteList ){
                    String t = m >= 10 ? h + ":" + m : h + ":0" + m;
                    res.add(t);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String>list = s.readBinaryWatch(1);
        for (String l : list){
            System.out.println(l);
        }
    }
}

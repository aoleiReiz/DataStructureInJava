package algorithm.trackpackrecur;

import com.sun.org.apache.bcel.internal.generic.LUSHR;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.nio.channels.Pipe;
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

    private boolean existHelper(char [][]board, boolean [][]visited, String target, int index, int r, int c){
        if (index == target.length() - 1){
            return target.charAt(index) == board[r][c];
        }
        if (target.charAt(index) == board[r][c]) {
            visited[r][c] = true;
            //上
            if (r - 1 >= 0 && !visited[r - 1][c]) {
                boolean flag = existHelper(board, visited, target, index + 1, r - 1, c);
                if (flag){
                    return true;
                }
            }
            // 下
            if (r + 1 < board.length && !visited[r + 1][c]) {
                boolean flag = existHelper(board, visited, target, index + 1, r + 1, c);
                if (flag){
                    return true;
                }
            }
            // 左
            if (c - 1 >= 0 && !visited[r][c - 1]) {
                boolean flag = existHelper(board, visited, target, index + 1, r, c - 1);
                if (flag){
                    return true;
                }
            }
            // 右
            if (c + 1 < board[0].length && !visited[r][c + 1]) {
                boolean flag = existHelper(board, visited, target, index + 1, r, c + 1);
                if (flag){
                    return true;
                }
            }
            visited[r][c] = false;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean []res = new boolean[1];
        for (int i = 0; i < board.length; i++) {
            boolean[][]visited = new boolean[board.length][board[0].length];
            for (int j = 0; j < board[i].length; j++) {
               if (existHelper(board, visited, word,0, i, j)){
                   return true;
               }
            }
        }
        return res[0];
    }


    public class Point{
        int x;
        int y;

        public Point(int _x, int _y){
            x = _x;
            y = _y;
        }
    }

    private void solveHelper(char [][]board, List<Point>path, boolean [][]visited, int startx, int starty, boolean []flags){
        if (flags[0]){
            return;
        }

        if (startx == 0 || startx == board.length-1 || starty == 0 || starty == board[0].length - 1){
            flags[0] = true;
        }

        visited[startx][starty] = true;
        path.add(new Point(startx, starty));
        // 上
        if (startx - 1 >= 0 && !visited[startx-1][starty] && board[startx -1][starty] == 'O'){
            solveHelper(board, path, visited, startx -1, starty, flags);
        }
        // 下
        if (startx + 1 < board.length && !visited[startx+1][starty] && board[startx +1][starty] == 'O'){
            solveHelper(board, path, visited, startx + 1, starty, flags);
        }
        //左
        if (starty - 1 >= 0 && !visited[startx][starty-1] && board[startx][starty-1] == 'O'){
            solveHelper(board, path, visited, startx, starty-1, flags);
        }
        //右
        if (starty + 1 < board[0].length && !visited[startx][starty+1] && board[startx][starty+1] == 'O'){
            solveHelper(board, path, visited, startx, starty+1, flags);
        }

    }

    public void solve(char[][] board) {
        if (null == board || board.length == 0)
            return;
        boolean [][]visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j]){
                    List<Point> path = new ArrayList<>();
                    boolean []flags = new boolean[1];
                    solveHelper(board, path, visited, i, j, flags);
                    if (!flags[0]){
                        for (Point p : path){
                            board[p.x][p.y] = 'X';
                            visited[p.x][p.y] = true;
                        }
                    }

                }
            }
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        char [][]board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        board = new char[][]{{'O'}};
        s.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print( board[i][j] + " ");
            }
            System.out.println();
        }

    }
}

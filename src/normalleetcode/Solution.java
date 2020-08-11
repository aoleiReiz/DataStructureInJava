package normalleetcode;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private int addDigitHelper(int num){
        int s = 0;
        while (num > 0){
            int t = num / 10;
            s += num - t * 10;
            num = t ;
        }
        return s;
    }
    public int addDigits(int num) {
       int n = addDigitHelper(num);
       while (n > 10){
           n = addDigitHelper(n);
       }
        return n;
    }


    private int binarySearch(int []nums, int key, int start){
        int l = start;
        int r = nums.length -1;
        while (l <= r){
            int mid = l + (r - l)/ 2;
            if (nums[mid] > key){
                r = mid -1;
            }else if (nums[mid] < key){
                l = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public int[] twoSum(int[] numbers, int target) {
        int []ret = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            int r = binarySearch(numbers, target - numbers[i], i+1);
            if (r >= 0){
                ret [0] = i+1;
                ret[1] = r + 1;
                break;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char [][]board = {{'X', 'X', 'X', 'X'},{'X', 'O', 'O', 'X'},{'X', 'X', 'O', 'X'},{'X', 'O', 'X', 'X'}};
        s.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (char c : board[i]){
                System.out.print(c + " ");
            }
            System.out.println();
        }

    }

    boolean isBorderPoint(int i, int j, int r, int c){
        return i==0 || i == r-1 || j==0 || j == c-1;
    }
    boolean isValidPoint(int i, int j, int r, int c){
        return i>=0 && i < r && j >=0 && j < c;
    }

    private final int [][]directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private void solveHelper(char[][] board, boolean[][]visited, int i, int j, int r, int c, List<int []> list, boolean[] flag){
        visited[i][j] = true;
        list.add(new int[]{i,j});
        if (isBorderPoint(i,j,r,c)){
            flag[0] = true;
        }
        for (int k = 0; k < 4; k++) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            if (isValidPoint(x,y,r,c) && board[x][y] == 'O' &&!visited[x][y]){
                if (isBorderPoint(x,y,r,c)){
                    flag[0] = true;
                }
                solveHelper(board,visited,x,y,r,c,list,flag);
            }
        }
    }
    public void solve(char[][] board) {
        if(null == board || board.length == 0)
            return;

        int r = board.length;
        int c = board[0].length;
        boolean [][]visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O' && !visited[i][j]){
                    boolean []flag = new boolean[1];
                    List<int[]>list = new ArrayList<>();
                    solveHelper(board,visited,i,j,r,c,list,flag);
                    if (!flag[0]){
                        for (int []a : list){
                            board[a[0]][a[1]] = 'X';
                        }
                    }
                }
            }
        }
    }



}

package algorithm.dp;

import java.util.Arrays;

public class SolutionDP {

    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        int prev = 1, cur = 1;
        for (int i = 2; i<=n; i++){
            int t = prev + cur;
            prev = cur;
            cur = t;
        }
        return cur;
    }


    public int minPathSum(int[][] grid) {
        if (null == grid || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int []row = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = -1;
                int left = -1;
                if (i- 1 >= 0){
                    up = grid[i-1][j];
                }
                if (j-1 >=0){
                    left = grid[i][j-1];
                }
                if (up >= 0 && left >=0) {
                    grid[i][j] = Math.min(up, left) + grid[i][j];
                }else if (up >= 0){
                    grid[i][j] = up + grid[i][j];
                }else if (left >= 0){
                    grid[i][j] = grid[i][j] + left;
                }
            }
        }
        return grid[m-1][n-1];
    }

    private int max3(int a, int b, int c){
        int x = Math.max(a, b);
        return Math.max(x, c);
    }
    public int integerBreak(int n) {
        int []memo = new int[n+1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memo[i] = max3(memo[i], j *(i - j),j * memo[i-j]);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        SolutionDP s = new SolutionDP();
        int [][]grid ={{0,2,2,6,4,1,6,2,9,9,5,8,4,4},{0,3,6,4,5,5,9,7,8,3,9,9,5,4},{6,9,0,7,2,2,5,6,3,1,0,4,2,5},{3,8,2,3,2,8,8,7,5,9,6,3,4,5},{4,0,1,3,9,2,0,1,6,7,9,2,8,9},{6,2,7,9,0,9,5,2,7,5,1,4,4,7},{9,8,3,3,0,6,8,0,8,8,3,5,7,3},{7,7,4,5,9,1,5,0,2,2,2,1,7,4},{5,1,3,4,1,6,0,4,3,8,4,3,9,9},{0,6,4,9,4,1,5,5,4,2,5,7,4,0},{0,1,6,6,4,9,2,7,8,2,1,3,3,7},{8,4,9,9,2,3,8,6,6,5,4,1,7,9}};
        System.out.println(s.minPathSum(grid));
    }
}

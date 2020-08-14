package normalleetcode;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

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
        int [][]nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int []ret = s.spiralOrder(nums);
        for (int i : ret)
            System.out.println(i);

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

    public Node helper(Node node, Map<Node,Node> visited) {
        if (null == node)
            return node;
        if (visited.containsKey(node))
            return visited.get(node);
        Node ret = new Node();
        ret.val = node.val;
        ret.neighbors = new ArrayList<>();
        visited.put(node,ret);
        for (Node n : node.neighbors){
            ret.neighbors.add(helper(n,visited));
        }
        return ret;
    }

    public Node cloneGraph(Node node) {
        Map<Node,Node>map = new HashMap<>();
        return helper(node,map);
    }

    public int[] exchange(int[] nums) {
        if (null == nums || nums.length <= 1){
            return nums;
        }
        int []ret = new int[nums.length];
        int i = 0, j = nums.length - 1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] % 2 == 1){
                ret[i++] = nums[k];
            }else {
                ret[j--] = nums[k];
            }
        }
        return ret;
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0|| matrix[0].length == 0){
            return new int[0];
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int []ret = new int[r * c];
        int k = 0;

        int left = 0, right = c - 1, top = 0, bottom = r - 1;
        while (true){
            // 从左到右
            for (int i = left; i <= right ; i++) {
                ret[k++] = matrix[top][i];
            }
            if (++top > bottom)
                break;
            //从上到下
            for (int i = top; i <= bottom ; i++) {
                ret[k++] = matrix[i][right];
            }
            if (--right < left)
                break;
            //从右到左
            for (int i = right; i >= left ; i--) {
                ret[k++] = matrix[bottom][i];
            }
            if (--bottom < top)
                break;
            //从下到上
            for (int i = bottom; i >= top ; i--) {
                ret[k++] = matrix[i][left];
            }
            if (++left > right)
                break;
        }
        return ret;
    }

    public int majorityElement(int[] nums) {
       int count = 0;
       int cur = 0;
       for (int i : nums){
           if (count == 0){
               cur = i;
           }
           if (i == cur){
               count ++;
           }else{
               count --;
           }
       }
       return cur;
    }

    public int[] twoSum2(int[] nums, int target) {
        int start = 0, end = nums.length -1;
        while (start < end){
            int sum = nums[start] + nums[end];
            if (sum < target){
                start ++;
            }else if (sum > target){
                end --;
            }else{
                return new int[]{nums[start],nums[end]};
            }
        }
        return new int[0];
    }




}

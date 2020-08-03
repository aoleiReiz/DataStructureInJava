package array;

import java.util.*;

public class Solution {

    public void rotate(int[][] matrix) {
        if (null == matrix || matrix.length == 0){
            return;
        }
        int i = 0;
        int j = 0;
        int n = matrix.length ;
        int m = matrix[0].length;
        while (i < n/2){
            int []temp = new int[m - 2 * j];
            for (int k = i; k < m - j; k++) {
                temp[k-i] = matrix[i][k];
            }
            //移动左
            for (int k = i; k < n - i; k++) {
                matrix[i][n-k-1] = matrix[k][j];
            }
            //移动下
            for (int k = n-j-1; k >= i; k--) {
                matrix[n-k-1][j] = matrix[n-i-1][n-k-1];
            }
            //移动右
            for (int k = j; k < n - j; k++) {
                matrix[n-i-1][k] = matrix[n-k-1][n-j-1];
            }
            //移动上
            for (int k = j; k < n-j; k++) {
                matrix[k][n-j-1] = temp[k-j];
            }
            i ++;
            j ++;
        }
    }

    public void printMatrix(int [][]matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int k : matrix[i]){
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        if (null == matrix || matrix.length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> clearedRow = new HashSet<>();
        Set<Integer> clearedCol = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    clearedCol.add(j);
                    clearedRow.add(i);
                }
            }
        }
        for (int i : clearedRow){
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j : clearedCol){
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0){
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int []ret = new int[m * n];
        int k = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0){
                int tempJ = i >= m ? m - 1 : i;
                for (int j = tempJ; j >= 0 && i -j < n ; j--) {
                    ret[k++] = matrix[j][i-j];
                }
            }else{
                int tempJ = i >= n ? n - 1 : i;
                for (int j = tempJ; j >= 0 && i - j < m; j--) {
                    ret[k++] = matrix[i-j][j];
                }
            }
        }
        return ret;
    }

    public int findMin(int[] nums) {
        for (int i = 0; i< nums.length-1;i++){
            if (nums[i] > nums[i+1]){
                return nums[i];
            }
        }
        return nums[0];
    }
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int []ret = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<numbers.length ; i++ ){
            int temp = target - numbers[i];
            if (map.containsKey(temp)){
                ret[0] = map.get(temp);
                ret[1] = i;
            } else{
                map.put(numbers[i],i);
            }
        }
        return ret;
    }

    public void rotateString(char[] str, int offset) {
        // write your code here
        offset = offset % str.length;
        char []temp = new char[offset];
        int n = str.length;
        for(int i = 1; i <=offset; i++){
            temp[i-1] = str[n-i];
        }
        for(int i = n - offset - 1; i >=0; i --){
            str[i+offset] = str[i];
        }
        for(int i = 0; i < offset; i++){
            str[i] = temp[offset - i -1];
        }
    }


}

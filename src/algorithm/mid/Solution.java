package algorithm.mid;

import java.util.*;

public class Solution {
    public void setZeroes(int[][] matrix) {
        if (null != matrix && matrix.length > 0){
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0){
                        row.add(i);
                        col.add(j);
                    }
                }
            }
            for (int i : row){
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
            for (int j : col){
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0){
            return 0;
        }
        int maxCount = 0;
        String sb = "";
        Map<Character,Integer>map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = sb.indexOf(c);
            if (index != -1){
                if (sb.length() > maxCount){
                    maxCount = sb.length();
                }
                int newStart = map.get(c) + 1;
                sb = s.substring(newStart,i+1);
                map.put(c, i);
            }else{
                map.put(c, i);
                sb += c;
            }
        }
        if (sb.length() > maxCount)
            maxCount = sb.length();
        return maxCount;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abba"));
    }
}

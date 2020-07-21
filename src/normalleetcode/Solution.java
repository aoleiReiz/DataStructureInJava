package normalleetcode;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Arrays;

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
        int []nums = {1,2,3,4,4,9,56,90};
        int []r = s.twoSum(nums, 100);
        for (int i : r) {
            System.out.println(i);
        }
    }


}

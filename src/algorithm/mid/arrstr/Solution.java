package algorithm.mid.arrstr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>ret = new ArrayList<>();

        if (nums.length >= 3){
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i-1]){
                    continue;
                }
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int temp = nums[i] + nums[l] + nums[r];
                    if (temp == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        ret.add(list);
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (r > l && nums[r] == nums[r + 1]) {
                            r--;
                        }

                    } else if (temp > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }

        }
        return ret;
    }
}

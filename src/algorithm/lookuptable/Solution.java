package algorithm.lookuptable;

import java.util.*;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int []ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                ret[0] = map.get(temp);
                ret[1] = i;
                return ret;
            }else{
                map.put(nums[i], i);
            }
        }
        return ret;
    }


    private List<List<Integer>> twoSumFromStart(int[] nums, int target, int start) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = start + 1; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                List<Integer>list = new ArrayList<>();
                list.add(nums[start]);
                list.add(nums[map.get(temp)]);
                list.add(nums[i]);
                ret.add(list);
            }else{
                map.put(nums[i], i);
            }
        }
        return ret;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>lists = new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>>set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            int target = -nums[i];
            List<List<Integer>> ret = twoSumFromStart(nums, target, i);
            set.addAll(ret);
        }
        lists.addAll(set);
        return lists;
    }

    private List<List<Integer>> fourSumHelper(int[] nums, int target, int start, int j){
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = start + 1; i < nums.length; i++) {
            if (i == j)
                continue;
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                List<Integer>list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[map.get(temp)]);
                ret.add(list);
            }else{
                map.put(nums[i], i);
            }
        }
        return ret;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        Set<List<Integer>> usedPairs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                List<Integer>list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                if (!usedPairs.contains(list)){
                    List<List<Integer>>twoSumRet = fourSumHelper(nums,target - nums[i]-nums[j],i,j);
                    for (List<Integer> list1 : twoSumRet){
                        list1.addAll(list);
                        Collections.sort(list1);
                        res.add(list1);
                    }
                    usedPairs.addAll(twoSumRet);
                }else{
                    usedPairs.add(list);
                }

            }
        }
        List<List<Integer>>ret = new ArrayList<>();
        ret.addAll(res);
        return ret;
    }


    private int fourSumCountHelper(Map<Integer, List<Integer>> mapC, Map<Integer, List<Integer>> mapD, int target){
        int count = 0;
        for (int kc : mapC.keySet()){
            int kd = target - kc;
            if (mapD.containsKey(kd)){
                List<Integer>lc =  mapC.get(kc);
                List<Integer>ld =  mapD.get(kd);
                count += lc.size() * ld.size();
            }
        }
        return count;
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;

        Map<Integer, List<Integer>>mapD = new HashMap<>();
        for (int i = 0; i < D.length; i++) {
            if (mapD.containsKey(D[i])){
                List<Integer> list = mapD.get(D[i]);
                list.add(i);
                mapD.put(D[i],list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                mapD.put(D[i],list);
            }
        }
        Map<Integer, List<Integer>>mapC = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            if (mapC.containsKey(C[i])){
                List<Integer> list = mapC.get(C[i]);
                list.add(i);
                mapC.put(C[i],list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                mapC.put(C[i],list);
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int target = -(A[i] + B[j]);
                count += fourSumCountHelper(mapC, mapD, target);
            }
        }
        return count;
    }

}

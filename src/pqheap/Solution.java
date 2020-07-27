package pqheap;

import java.util.*;


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (treeMap.containsKey(nums[i])){
                treeMap.put(nums[i],treeMap.get(nums[i]) + 1);
            }else{
                treeMap.put(nums[i],1);
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return treeMap.get(o1) - treeMap.get(o2);
            }
        });
        for (Map.Entry<Integer,Integer>entry : treeMap.entrySet()){
            if (priorityQueue.size() < k){
                priorityQueue.add(entry.getKey());
            }
            else if (entry.getValue() > treeMap.get(priorityQueue.peek())){
                priorityQueue.remove();
                priorityQueue.add(entry.getKey());
            }
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (!priorityQueue.isEmpty()){
            linkedList.add(priorityQueue.remove());
        }
        return linkedList;
    }
}

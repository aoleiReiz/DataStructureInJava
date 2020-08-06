package stackqueue;

import java.util.Queue;

import java.util.ArrayDeque;

public class MovingAverage {

    private int size;
    private Queue<Integer> queue;
    private int curSum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new ArrayDeque<Integer>();
    }

    public double next(int val) {
        if (queue.size() == this.size){
            int i = queue.remove();
            curSum = curSum - i + val;
        }else{
            curSum += val;
        }
        queue.add(val);
        return curSum * 1.0 / queue.size();
    }
}

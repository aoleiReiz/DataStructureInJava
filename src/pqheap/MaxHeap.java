package pqheap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MaxHeap <E extends Comparable<E>> {

    private List<E>data;

    public MaxHeap(){
        data = new ArrayList<>();
    }

    // 返回堆中的元素个数
    public int size(){
        return data.size();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回一个节点的父节点的索引
    private int parent(int i){
        assert i > 0;
        return (i - 1) / 2;
    }

    //返回一个节点的左孩子
    private int leftChild(int i){
        return 2 * i + 1;
    }

    //返回一个节点的右孩子
    private int rightChild(int i){
        return 2 * i + 2;
    }

    private void swap(int i, int j){
        E e = data.get(i);
        data.set(i,data.get(j));
        data.set(j, e);
    }

    public void add(E e){
        data.add(e);
        siftUp(data.size() - 1);
    }

    private void siftUp(int k){
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            swap(k, parent(k));
            k = parent(k);
        }
    }

    // 看堆中的最大元素
    public E findMax(){
        if(data.size() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }
    // 取出堆中最大元素
    public E extractMax(){

        E ret = findMax();

        swap(0, data.size() - 1);
        data.remove(data.size()-1);
        siftDown(0);

        return ret;
    }

    private void siftDown(int k){

        while(leftChild(k) < data.size()){
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            if( j + 1 < data.size() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0 )
                j ++;
            // data[j] 是 leftChild 和 rightChild 中的最大值

            if(data.get(k).compareTo(data.get(j)) >= 0 )
                break;

            swap(k, j);
            k = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e){

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    public MaxHeap(E[] arr){
        data = new ArrayList<E>(Arrays.asList(arr));
        if(arr.length != 1){
            for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
                siftDown(i);
        }
    }

}

package pqheap;

import java.util.ArrayList;
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


}

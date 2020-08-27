package algorithm.sort;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Random;

public class SortTest {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        SortHelper sortHelper = new SortHelper();
        Integer []arr = sortHelper.generateRandomNumbers(50000);
        Integer []arr2 = new Integer[arr.length];
        Integer []arr3 = new Integer[arr.length];
        Integer []arr4 = new Integer[arr.length];
        Integer []arr6 = new Integer[arr.length];
        arr2 = Arrays.copyOf(arr,arr2.length);
        arr3 = Arrays.copyOf(arr, arr3.length);
        arr4 = Arrays.copyOf(arr, arr4.length);
        arr6 = Arrays.copyOf(arr, arr6.length);
        Integer []arr5 = Arrays.copyOf(arr, arr.length);
        System.out.println("Random arr");
        sortHelper.testSort("selectionSort", arr);
        sortHelper.testSort("insertionSort", arr2);
        sortHelper.testSort("mergeSort", arr3);
        sortHelper.testSort("insertionSortImprove", arr4);
        sortHelper.testSort("bubbleSort", arr5);
        sortHelper.testSort("mergeSortBU",arr6);

        System.out.println("Nearly Sorted arr");
        Integer []nearlySortedArr = sortHelper.generateNearlySortedNumbers(50000, 300);
        Integer []nearlySortedArr2 = Arrays.copyOf(nearlySortedArr,nearlySortedArr.length);
        Integer []nearlySortedArr3 = Arrays.copyOf(nearlySortedArr,nearlySortedArr.length);
        Integer []nearlySortedArr4 = Arrays.copyOf(nearlySortedArr,nearlySortedArr.length);
        Integer []nearlySortedArr5 = Arrays.copyOf(nearlySortedArr,nearlySortedArr.length);
        sortHelper.testSort("selectionSort", nearlySortedArr);
        sortHelper.testSort("insertionSort", nearlySortedArr2);
        sortHelper.testSort("mergeSort", nearlySortedArr3);
        sortHelper.testSort("insertionSortImprove", nearlySortedArr4);
        sortHelper.testSort("bubbleSort", nearlySortedArr5);
    }
}

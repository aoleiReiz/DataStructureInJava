package algorithm.sort;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class SortTest {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        SortTest sortTest = new SortTest();
        SortHelper sortHelper = new SortHelper();
        Integer []arr = sortHelper.generateRandomNumbers(40000);
        sortHelper.testSort("selectionSort", arr);

    }
}

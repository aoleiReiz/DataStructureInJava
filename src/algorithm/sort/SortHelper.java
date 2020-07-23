package algorithm.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class SortHelper {
    public Integer [] generateRandomNumbers(int N){
        Random random = new Random();
        Integer t = random.nextInt();
        Integer []ret = new Integer[N];
        for (int i = 0; i < N; i++) {
            ret[i] = random.nextInt(50000);
        }
        return ret;
    }

    public Integer [] generateNearlySortedNumbers(int N, int swapTimes){
        Random random = new Random();
        Integer t = random.nextInt();
        Integer []ret = new Integer[N];
        for (int i = 0; i < N; i++) {
            ret[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            int index = random.nextInt(N);
            ret[index] = random.nextInt(50000);
        }

        return ret;
    }

    public void testSort(String sortName, Comparable []a) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        long start = System.nanoTime();
        Sort sort = new Sort();
        Method m = sort.getClass().getMethod(sortName, Comparable[].class);
        m.invoke(sort, (Object) a);
        long end = System.nanoTime();
        boolean flag = sort.isSorted(a);
        if (flag){
            System.out.println("排序成功");
        }else{
            System.out.println("排序失败");
        }
        System.out.println(sortName +" sort using " + (end - start)/ 1000000000.);
    }

}

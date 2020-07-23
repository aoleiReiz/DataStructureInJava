package algorithm.sort;

public class Sort {

    public boolean isSorted(Comparable []a){
        for (int i = 1; i < a.length; i++) {
            if (comp(a[i-1],a[i]) > 0){
                return false;
            }
        }
        return true;
    }

    public void exch(Comparable []a, int i, int j){
        assert i < a.length && j < a.length;
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public int comp(Comparable a, Comparable b){
        return a.compareTo(b);
    }

    public void selectionSort(Comparable []a){
        if (null == a || a.length <= 1){
            return;
        }
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (comp(a[j],a[min]) < 0){
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public void insertionSort(Comparable []a){
        if (null == a || a.length <= 1){
            return;
        }
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && comp(a[j],a[j-1]) < 0; j--){
                exch(a, j , j -1);
            }
        }
    }
}

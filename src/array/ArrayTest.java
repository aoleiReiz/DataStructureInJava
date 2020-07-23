package array;

public class ArrayTest {

    public static void main(String[] args) {
        int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Solution s = new Solution();
       int [] ret = s.findDiagonalOrder(matrix);
        for (int i : ret) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

package stackqueue;

public class StackQueueTest {
    public static void main(String[] args) {
        StackQueueSolution s = new StackQueueSolution();
        int [][]martrix = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        s.wallsAndGates(martrix);
        for (int i = 0; i < martrix.length; i++) {
            for (int j = 0; j < martrix[i].length; j++) {
                System.out.print(martrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

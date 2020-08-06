package stackqueue;

public class CustomStack {

    private int []data;
    private int top;

    public CustomStack(int maxSize) {
        data = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top < data.length-1){
            data[++top] = x;
        }
    }

    public int pop() {
        if (top == -1){
            return -1;
        }else{
            return data[top --];
        }
    }

    public void increment(int k, int val) {
        int j = 0;
        for (int i = 0; i < k; i++) {
            if (j <= top){
                data[j] += val;
                j ++;
            }
        }
    }
}

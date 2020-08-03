package array;

public class ArrayTest {

    public static void main(String[] args) {
        char[] str = "abcdefg".toCharArray();
        Solution s = new Solution();
        s.rotateString(str, 10);
        System.out.println(new String(str));
    }
}

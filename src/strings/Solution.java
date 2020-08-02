package strings;

public class Solution {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n1 = num1.length() -1;
        int n2 = num2.length() -1;
        int jinwei = 0;
        while (n1 >= 0 && n2 >= 0){
            int n = (num1.charAt(n1) - '0') + (num2.charAt(n2) - '0') + jinwei;
            if (n >= 10){
                sb.append(n % 10);
                jinwei = 1;
            }else{
                sb.append(n % 10);
                jinwei = 0;
            }
            n1 --;
            n2 --;
        }
        while (n1 >= 0){
            int n = (num1.charAt(n1) - '0') + jinwei;
            if (n >= 10){
                sb.append(n % 10);
                jinwei = 1;
            }else{
                sb.append(n % 10);
                jinwei = 0;
            }
            n1 --;
        }
        while (n2 >= 0){
            int n = (num2.charAt(n2) - '0') + jinwei;
            if (n >= 10){
                sb.append(n % 10);
                jinwei = 1;
            }else{
                sb.append(n % 10);
                jinwei = 0;
            }
            n2 --;
        }
        if (jinwei == 1){
            sb.append(jinwei);
        }

        return sb.reverse().toString();
    }
}

package algorithm.trackpackrecur;

import java.util.ArrayList;
import java.util.List;

public class TB {

    private void stringPermHelper(String string, boolean []mark, int k, String cur ,List<String> res){
        if (cur.length() == string.length()){
            res.add(cur);
            cur = "";
        }else{
            for (int i = 0; i < mark.length; i++) {
                if (!mark[i]){
                    mark[i] = true;
                    stringPermHelper(string, mark,k+1,cur + string.charAt(i),res);
                    mark[i]= false;
                }
            }
        }
    }
    public List<String> stringPerm(String string){
        List<String> res = new ArrayList<>();
        boolean []mark = new boolean[string.length()];
        stringPermHelper(string, mark, 0,"" ,res);
        return res;
    }

    public static void main(String[] args) {
        String string = "ABCD";
        TB tb = new TB();
        List<String>res = tb.stringPerm(string);
        System.out.println(res.size());
        for (String s : res){
            System.out.println(s);
        }
    }

}

package trie;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

    public class Node{
        public int val;
        public Map<Character, Node> next;

        public Node(){
            val = 0;
            next = new HashMap<>();
        }

        public Node(int _val){
            val = _val;
            next = new HashMap<>();
        }

    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!cur.next.containsKey(c)){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.containsKey(c)){
                cur = cur.next.get(c);
            }else{
                return 0;
            }
        }
        return helperSum(cur);
    }

    private int helperSum(Node cur){
        int sum = cur.val;
        for (char c : cur.next.keySet()){
            sum += helperSum(cur.next.get(c));
        }
        return sum;
    }

}

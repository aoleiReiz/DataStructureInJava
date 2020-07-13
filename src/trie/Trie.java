package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    class Node{
        public boolean isWord;
        public Map<Character, Node> next;

        public Node(){
            isWord = false;
            next = new HashMap<>();
        }

        public Node(boolean _isWord, Map<Character, Node> _next){
            isWord = _isWord;
            next = _next;
        }
    }

    private Node root;

    public Trie(){
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for(int i =0; i< word.length(); i++){
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord){
            cur.isWord = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for(int i =0; i< word.length(); i++){
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)){
               return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix){
        Node cur = root;
        for(int i =0; i< prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}

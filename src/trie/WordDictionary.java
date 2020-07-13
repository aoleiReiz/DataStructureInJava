package trie;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {

    class Node{
        public boolean isWord;
        public Map<Character, Node> next;

        public Node(){
            isWord = false;
            next = new HashMap<>();
        }

    }

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i =0; i < word.length(); i++){
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(Node cur, String word, int index){
        if (index == word.length()){
            return cur.isWord;
        }
        if (word.charAt(index) != '.'){
            if (!cur.next.containsKey(word.charAt(index))){
                return false;
            }
            return searchHelper(cur.next.get(word.charAt(index)), word, index+1);
        }else{
            for (Character key : cur.next.keySet()){
                if (searchHelper(cur.next.get(key), word, index + 1)){
                    return true;
                }
            }
            return false;
        }
    }

}
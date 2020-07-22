package bst;

import java.util.*;

public class BSTIterator {

    private Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new ArrayDeque<>();
       inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (null == root){
            return;
        }
        inOrder(root.left);
        queue.add(root.val);
        inOrder(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return queue.remove();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

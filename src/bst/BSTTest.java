package bst;

public class BSTTest {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        Solution s = new Solution();
        System.out.println(s.isValidBST(node1));

    }
}

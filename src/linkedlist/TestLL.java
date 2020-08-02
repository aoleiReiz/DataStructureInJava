package linkedlist;

public class TestLL {
    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node1.random = null;

        node2.next = node3;
        node2.random = node1;

        node3.next = node4;
        node3.random = node5;

        node4.next = node5;
        node4.random = node3;

        node5.random = node1;

        Solution s = new Solution();
        Node r = s.copyRandomList(node1);

        Node p = node1;
        while (p != null){
            System.out.println(p);
            p = p.next;
        }

        System.out.println("**********");

        while (r != null){
            System.out.println(r);
            System.out.println("-- rand " + r.random);
            r = r.next;
        }

    }
}

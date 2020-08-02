package linkedlist;

public class MyLinkedList {

    public class SinglyListNode {
        int val;
        SinglyListNode next;
        SinglyListNode(int x) { val = x; }
    }

    private SinglyListNode dummyHead;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummyHead = new SinglyListNode(-1);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        SinglyListNode p = dummyHead.next;
        int i = 0;
        while (i < index && p != null){
            p = p.next;
            i++;
        }
        return p!=null ? p.val : -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        SinglyListNode head = dummyHead.next;
        SinglyListNode tmpCell = new SinglyListNode(val);
        tmpCell.next = head;
        dummyHead.next = tmpCell;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        SinglyListNode p = dummyHead;
        while (p.next != null){
            p = p.next;
        }
        SinglyListNode tmpCell = new SinglyListNode(val);
        p.next = tmpCell;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        SinglyListNode p = dummyHead;
        int i = -1;
        while (i < index - 1 && p.next != null){
            p = p.next;
            i ++;
        }
        if(p != null){
            SinglyListNode tmpCell = new SinglyListNode(val);
            tmpCell.next = p.next;
            p.next = tmpCell;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        SinglyListNode p = dummyHead;
        int i = -1;
        while (i < index - 1 && p.next != null){
            p = p.next;
            i++;
        }

        if( i == index - 1){
            SinglyListNode tmpCell = p.next;
            if(tmpCell != null)
                p.next = tmpCell.next;
        }
    }
}

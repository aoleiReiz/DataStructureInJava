package linkedlist;

import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean hasCycle(ListNode head) {
        if (null == head || head.next == null){
            return false;
        }
        ListNode fastNode = head.next.next;
        ListNode slowNode = head.next;
        while (slowNode.next != null && fastNode.next!=null && fastNode.next.next != null){
            if (fastNode == slowNode){
                return true;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if (null == head || head.next == null){
            return null;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if (fastNode == slowNode){
                break;
            }
        }
        if (fastNode == null || fastNode.next == null){
            return null;
        }

        ListNode curr = head;
        while(curr != fastNode){
            curr = curr.next;
            fastNode = fastNode.next;
        }
        return curr;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        int count = 0;
        while (p != null){
            count ++;
            p = p.next;
        }
        k = k % count;

        ListNode pHead = head;

        for (int i = 0; i < k; i++) {
            ListNode pTailPrev = pHead;
            while (pTailPrev.next.next != null){
                pTailPrev = pTailPrev.next;
            }
            ListNode tmpCell = pTailPrev.next;
            tmpCell.next = pHead;
            pTailPrev.next = null;
            pHead = tmpCell;
        }
        return pHead;
    }

    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>(); //创建HashMap集合
        Node cur=head;
        //复制结点值
        while(cur!=null){
            //存储put:<key,value1>
            map.put(cur,new Node(cur.val)); //顺序遍历，存储老结点和新结点(先存储新创建的结点值)
            cur=cur.next;
        }
        //复制结点指向
        cur = head;
        while(cur!=null){
            //得到get:<key>.value2,3
            map.get(cur).next = map.get(cur.next); //新结点next指向同旧结点的next指向
            map.get(cur).random = map.get(cur.random); //新结点random指向同旧结点的random指向
            cur = cur.next;
        }

        //返回复制的链表
        return map.get(head);
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }
        if (head.val == val){
            return head.next;
        }else{
            ListNode p = head;
            while (p.next != null && p.next.val != val){
                p = p.next;
            }
            if (p.next != null){
                ListNode d = p.next;
                p.next = d.next;
            }
            return head;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (null == head) {
            return null;
        }
        ListNode pre = head;
        ListNode post = head;
        for (int i = 0; i < k && pre != null; i++) {
            pre = pre.next;
        }
        while (pre != null) {
            pre = pre.next;
            post = post.next;
        }
        return post;
    }


    private ListNode reverseListHelper(ListNode prev, ListNode cur) {
        if (null == cur){
            return prev;
        }
        ListNode next = cur.next;
        cur.next = prev;
        return reverseListHelper(cur, next);
    }
    public ListNode reverseList(ListNode head) {
        if (null == head){
            return null;
        }
        return reverseListHelper(null, head);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                p.next = l1;
                p = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                p = l2;
                l2 = l2.next;
            }
        }
        while (l1 != null){
            p.next = l1;
            p = l1;
            l1 = l1.next;
        }
        while (l2 != null){
            p.next = l2;
            p = l2;
            l2 = l2.next;
        }
        return dummyHead.next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            curA = curA != null ? curA.next : headB;
            curB = curB != null ? curB.next : headA;
        }
        return curA;
    }
}

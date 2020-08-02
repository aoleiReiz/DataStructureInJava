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

}

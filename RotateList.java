//https://leetcode.com/problems/rotate-list/description/

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
        return head;

        //Find size and connect to head.
        ListNode current = head;
        int size = 1;
        while(current.next != null)
        {
            current = current.next;
            size++;
        }
        k = k%size;
        if(k == 0)
        return head;

        current.next = head;

        ListNode newStart = split(head, size-k);
        return newStart;
    }

    public static ListNode split(ListNode head, int k)
    {
        ListNode prev = null;
        ListNode current = head;
        for(int i = 0; i < k; i++)
        {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        return current;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

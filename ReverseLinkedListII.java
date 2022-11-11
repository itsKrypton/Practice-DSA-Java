//https://leetcode.com/problems/reverse-linked-list-ii/submissions/841241914/

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)
        return head;

        ListNode prev = null;
        ListNode beforeStart = null;
        ListNode curr = head;

        for (int i = 1; i < left; i++) 
        {
            prev = curr;
            curr = curr.next;    
        }
        beforeStart = prev;
        ListNode next = curr.next;

        ListNode begin = curr;
        for(int i = 0; i <= (right - left); i++)
        {
            curr.next = prev;
            prev = curr;
            curr = next;

            if(next != null)
            next = next.next;
        }

        if(beforeStart != null)
        beforeStart.next = prev;

        begin.next = curr;

        if(left > 1)
        return head;

        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

//https://leetcode.com/problems/reorder-list/description/

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head.next == null)
        return;

        ListNode prevMid = getMid(head);
        ListNode reversedStart = reverseList(prevMid.next);
        prevMid.next = null;

        ListNode start = head;
        ListNode nextStart = start.next;
        ListNode nextReversedStart = reversedStart.next;

        while(start != null && reversedStart != null)
        {
            start.next = reversedStart;
            if(!(nextStart == null && nextReversedStart != null))
            reversedStart.next = nextStart;

            start = nextStart;
            reversedStart = nextReversedStart;

            if(nextStart != null)
            nextStart = nextStart.next;

            if(nextReversedStart != null)
            nextReversedStart = nextReversedStart.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null)
        return null;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while(curr != null)
        {
            curr.next = prev;
            prev = curr;
            curr = next;

            if(next != null)
            next = next.next;
        }

        return prev;
    }

    public ListNode getMid(ListNode head)
    {
        ListNode midPrev = null;
        while(head != null && head.next != null)
        {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        return midPrev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

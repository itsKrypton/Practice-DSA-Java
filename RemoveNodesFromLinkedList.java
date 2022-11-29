public class RemoveNodesFromLinkedList {
    public ListNode removeNodes(ListNode head) {
        ListNode newHead = reverseList(head);

        int currentMax = newHead.val;
        ListNode curr = newHead;
        ListNode next = curr.next;

        while(curr.next != null) 
        {
            if(next.val < currentMax)
            {
                curr.next = next.next;
                next = curr.next;
            }

            else
            {
                currentMax = next.val;
                curr = next;
                next = next.next;
            }
        }

        return reverseList(newHead);
    }

    public static ListNode reverseList(ListNode head) {
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

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

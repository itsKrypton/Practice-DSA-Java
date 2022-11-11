//https://leetcode.com/problems/sort-list/

/* Here the getMid method is modified where we are separating the two lists into left and right at the middle value. First list is head to node before mid and next
 * is mid to end.
 */

public class MergeSortLinkedList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        return head;

        ListNode middle = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);

        return mergeTwoLists(left, right);
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode();
        ListNode head = newNode;

        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                newNode.next = list1;
                list1 = list1.next;
            }

            else
            {
                newNode.next = list2;
                list2 = list2.next;
            }

            newNode = newNode.next;
        }

        if(list1 != null)
        newNode.next = list1;

        if(list2 != null)
        newNode.next = list2;

        return head.next;
    }
    
    /* public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    } */

    public ListNode getMid(ListNode head)
    {
        ListNode midPrev = null;
        while(head != null && head.next != null)
        {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

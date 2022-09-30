/* To find where the cycle starts, first find if a loop exists and if it does then find the length of the loop. Next take two pointers first and second and make second 
 * pointer go ahead length of the cycle times. Now move both pointers one at a time and where they meet will be your answer.
*/


public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        int length = lengthOfCycle(head);
        if(length == -1)
        return null;

        ListNode first = head;
        ListNode second = head;

        while(length-- > 0)
        second = second.next;

        while(first != second)
        {
            first = first.next;
            second = second.next;
        }

        return first;
    }

    public static int lengthOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        do
        {
            if(fast == null || fast.next == null)
            return -1;

            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != fast);

        int length = 0;
        do
        {
            slow = slow.next;
            length++;
        }
        while(slow != fast);

        return length;
    }

    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode(int x) { this.val = x; this.next = null; }
    }
}

// https://leetcode.com/problems/linked-list-cycle/submissions/

/* If any problem deals with cycle, use fast and slow pointer method. It is used for cycle detection. Fast pointer moves 2x faster than slow pointer. If there is a
 * circle then fast and slow are bound to meet in which case you can return true, else fast pointer will reach null in which case return false.
 */

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        do
        {
            if(fast == null || fast.next == null)
            return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != fast);

        return true;
    }

    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode(int x) { this.val = x; this.next = null; }
    }
}

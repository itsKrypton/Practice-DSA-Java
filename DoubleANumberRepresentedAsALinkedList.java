// https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/

public class DoubleANumberRepresentedAsALinkedList {
    public ListNode doubleIt(ListNode head) {
        int[] carry = new int[1];
        head = helper(head, carry);
        
        if(carry[0] != 0)
        {
            ListNode newHead = new ListNode(carry[0]);
            newHead.next = head;
            return newHead;
        }
        
        return head;
    }
    
    public ListNode helper(ListNode head, int[] carry)
    {
        if(head == null)
        return null;
        
        helper(head.next, carry);

        int newValue = ((head.val * 2) + carry[0]);
        carry[0] = newValue / 10;
        head.val = newValue % 10;
        
        return head;
    }

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
}

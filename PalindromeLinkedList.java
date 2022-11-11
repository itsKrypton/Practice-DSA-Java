//https://leetcode.com/problems/palindrome-linked-list/description/

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null)
        return true;

        ListNode mid = getMid(head);
        ListNode reversedStart = reverseList(mid);

        ListNode midCopy = reversedStart;
        ListNode start = head;
        while(start != null && midCopy != null)
        {
            if(start.val != midCopy.val)
            break;

            start = start.next;
            midCopy = midCopy.next;
        }
        reverseList(reversedStart);
        
        return start == null || midCopy == null;
    }

    public ListNode getMid(ListNode head)
    {
        ListNode midPrev = null;
        while(head != null && head.next != null)
        {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        return midPrev.next;
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

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

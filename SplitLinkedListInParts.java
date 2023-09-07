// https://leetcode.com/problems/split-linked-list-in-parts/description/

public class SplitLinkedListInParts {
    /*
     * Find the length of the list and divide it by k to get the size of first group. Decrease the length by the size of first group and k by 1 and find the size of next
     * group and keep doing this until k groups have been made.
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int length = lengthOfList(head);
        int index = 0;

        for(index = 0; index < k; index++)
        {
            ans[index] = head;
            int currentSize = ((length - 1) / (k - index)) + 1;
            length -= currentSize;

            while(head != null && currentSize-- > 0)
            {
                ListNode prev = head;
                head = head.next;

                if(currentSize == 0)
                prev.next = null;
            }
        }

        return ans;
    }

    public int lengthOfList(ListNode head)
    {
        int length = 0;
        while(head != null)
        {
            length++;
            head = head.next;
        }

        return length;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

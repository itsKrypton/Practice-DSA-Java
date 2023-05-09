// https://leetcode.com/problems/merge-k-sorted-lists/description/

/* Uses the concept from MergeSort and MergeSortInPlace. Keep dividing the array till we have left and right array having one list each. After that use those lists in MergeTwoSortedLists
 * method. Return the head node of this function as a new array/head of the node.
 */

//import java.util.Arrays;

public class MergeKSortedLists {
    // Only the new list is the extra space.
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return divide(lists, 0, lists.length - 1);
    }

    public static ListNode divide(ListNode[] lists, int start, int end)
    {
        if(start == end)
        return lists[start]; 

        int mid = start + (end - start) / 2;

        ListNode left = divide(lists, start, mid);
        ListNode right = divide(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

    // Uses extra storage by creating new arrays.
    /* public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return divide(lists)[0];
    }

    public static ListNode[] divide(ListNode[] lists)
    {
        if(lists.length == 1)
        return lists; 

        int mid = lists.length / 2;

        ListNode[] left = divide(Arrays.copyOfRange(lists, 0, mid));
        ListNode[] right = divide(Arrays.copyOfRange(lists, mid, lists.length));

        return mergeTwoLists(left[0], right[0]);
    }


    public static ListNode[] mergeTwoLists(ListNode list1, ListNode list2) {
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

        return new ListNode[]{head.next};
    } */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        int numberOfGroups = totalNumber(head, k);
        ListNode curr = head;
        ListNode prevStart = head;
        for (int i = 0; i < numberOfGroups; i++)
        {
            ListNode a = curr;
            ListNode top = a;
            ListNode b = a.next;
            for (int j = 0; j < k - 1; j++){
                ListNode temp = a;
                a = b;
                b = b.next;
                a.next = temp;   
            }
			
            if (i == 0) head = a;
            prevStart.next = a;
            curr = b;
            prevStart = top;
        }

        prevStart.next = curr;
        return head;
    }

    public static int totalNumber(ListNode head, int k)
    {
        ListNode current = head;
        int count = 0;
        while(current != null)
        {
            current = current.next;
            count++;
        }
        return (count/k);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /* Recursive approach */
    /* public ListNode reverseKGroup(ListNode head, int k) {
        ListNode currentNode = head;
        ListNode nextNode = null;
        ListNode previousNode = null;
        int count = 1;
        boolean lastGroup = true;
        while(count <= k && currentNode != null)
        {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            count++;
        }
        if(count <= k)
        return reverseList(previousNode);

        if(nextNode != null)
        head.next = reverseKGroup(nextNode, k);

        return previousNode;
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
    } */
}

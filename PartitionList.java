public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode partition = head;
        ListNode prevPartition = null;

        // Find the partition element
        while(partition != null && partition.val < x)
        {
            prevPartition = partition;
            partition = partition.next;
        }

        // Find the nodes less than x and move it before partition
        ListNode current = partition;
        ListNode prev = prevPartition;

        while(current != null)
        {
            if(current.val < x)
            {
                // If there is no node before partition
                if(prevPartition == null)
                prevPartition = head = current;

                // If there is a node before partition
                else
                {
                    prevPartition.next = current;
                    prevPartition = prevPartition.next;
                }
                
                prev.next = current.next;
                current.next = partition;

                current = prev.next;
            }

            else
            {
                prev = current;
                current = current.next;
            }
        }

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

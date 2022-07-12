public class AmazonReverseListGroup
{
    public static Node reverse(Node node, int k)
    {
        Node currentNode = node;
        Node nextNode = null;
        Node previousNode = null;
        int count = 1;
        while(count <= k && currentNode != null)
        {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            count++;
        }
        if(nextNode != null)
        {
            node.next = reverse(nextNode, k);
        }
        return previousNode;
    }

    class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }
}
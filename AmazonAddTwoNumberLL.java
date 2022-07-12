public class AmazonAddTwoNumberLL {
    
    public static Node addTwoLists(Node first, Node second) {
        first = reverseList(first);
        second = reverseList(second);
        Node currentFirstNode = first;
        Node currentSecondNode = second;
        Node prevNode = new Node(0);
        Node headNode = new Node(0);

        int count = 0;
        int currentValue = 0;
        int carry = 0;
        while(currentFirstNode != null || currentSecondNode != null)
        {
            if(currentFirstNode != null && currentSecondNode != null)
            {
                currentValue = currentFirstNode.data + currentSecondNode.data + carry;
                carry = (currentValue > 9) ? 1 : 0;
                currentValue %= 10;
                Node node = new Node(currentValue);
                if(count == 0)
                {
                    headNode = node;
                    prevNode = headNode;
                    count++;
                }

                else
                {
                    prevNode.next = node;
                    prevNode = node;
                    count++;
                }

                currentFirstNode = currentFirstNode.next;
                currentSecondNode = currentSecondNode.next;
            }

            else if(currentFirstNode != null && currentSecondNode == null)
            {
                currentValue = currentFirstNode.data + carry;
                carry = (currentValue > 9) ? 1 : 0;
                currentValue %= 10;
                Node node = new Node(currentValue);
                if(count == 0)
                {
                    headNode = node;
                    prevNode = headNode;
                    count++;
                }

                else
                {
                    prevNode.next = node;
                    prevNode = node;
                    count++;
                }

                currentFirstNode = currentFirstNode.next;
            }

            else if(currentFirstNode == null && currentSecondNode != null)
            {
                currentValue = currentSecondNode.data + carry;
                carry = (currentValue > 9) ? 1 : 0;
                currentValue %= 10;
                Node node = new Node(currentValue);
                if(count == 0)
                {
                    headNode = node;
                    prevNode = headNode;
                    count++;
                }

                else
                {
                    prevNode.next = node;
                    prevNode = node;
                    count++;
                }

                currentFirstNode = currentSecondNode.next;
            }
        }

        if(carry > 0)
        {
            Node node = new Node(carry);
            if(count == 0)
            {
                headNode = node;
                prevNode = headNode;
                count++;
            }

            else
            {
                prevNode.next = node;
                prevNode = node;
                count++;
            }
        }

        return reverseList(headNode);
    }

    public static Node reverseList(Node node)
    {
        Node currentNode = node;
        Node nextNode = null;
        Node previousNode = null;
        while(currentNode != null)
        {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }
}

class Node 
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Similar problem as All Nodes Distance K In Binary Tree, you find the parent nodes, store it in a hashmap and then do a BFS traversal to find the maximum distance
 * until you can't branch out any further. Just minor changes to calculate distance. Here you also need to create a function to find the node of the given start value.
 */

public class TimeToBurnTree {
    public static int timeToBurnTree(BinaryTreeNode root, int start)
    {
        HashMap<BinaryTreeNode, BinaryTreeNode> map = new HashMap<>();
        markParents(root, map); 

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        HashMap<BinaryTreeNode, Boolean> visited = new HashMap<>();
        BinaryTreeNode startNode = findNode(root, start);
        queue.add(startNode);
        visited.put(startNode, true);
        int distance = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            boolean hasNext = false;

            while(size-- > 0)
            {
                BinaryTreeNode current = queue.poll();

                if(current.left != null && visited.get(current.left) == null)
                {
                    hasNext = true;
                    visited.put(current.left, true);
                    queue.add(current.left);
                }

                if(current.right != null && visited.get(current.right) == null)
                {
                    hasNext = true;
                    visited.put(current.right, true);
                    queue.add(current.right);
                }

                if(map.containsKey(current) && visited.get(map.get(current)) == null)
                {
                    hasNext = true;
                    visited.put(map.get(current), true);
                    queue.add(map.get(current));
                }
            }

            if(hasNext)
            distance++;
        }

        return distance;
    }

    public static BinaryTreeNode findNode(BinaryTreeNode root, int val)
    {
        if(root == null)
        return null;

        if(root.val == val)
        return root;

        BinaryTreeNode left = findNode(root.left, val);
        if(left != null) return left;
        BinaryTreeNode right = findNode(root.right, val);
        if(right != null) return right;

        return null;
    }

    public static void markParents(BinaryTreeNode root, HashMap<BinaryTreeNode, BinaryTreeNode> map)
    {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            while(size-- > 0)
            {
                BinaryTreeNode current = queue.poll();

                if(current.left != null)
                {
                    map.put(current.left, current);
                    queue.add(current.left);
                }

                if(current.right != null)
                {
                    map.put(current.right, current);
                    queue.add(current.right);
                }
            }
        }
    }

    public class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode() {}
        BinaryTreeNode(int val) { this.val = val; }
        BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

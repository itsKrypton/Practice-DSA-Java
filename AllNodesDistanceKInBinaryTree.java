import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * First we need to mark the parents of all nodes by traversing and store them in a hashmap. Next we do a BFS traversal to check all the nodes from the target node
 * at the distance k. We can then return the answer.
 */

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        markParents(root, map); // To mark the parents of all nodes

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        queue.add(target);
        visited.put(target, true);
        int distance = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            if(distance == k)
            break;

            distance++;
            while(size-- > 0)
            {
                TreeNode current = queue.poll();

                if(current.left != null && visited.get(current.left) == null)
                {
                    visited.put(current.left, true);
                    queue.add(current.left);
                }

                if(current.right != null && visited.get(current.right) == null)
                {
                    visited.put(current.right, true);
                    queue.add(current.right);
                }

                if(map.containsKey(current) && visited.get(map.get(current)) == null)
                {
                    visited.put(map.get(current), true);
                    queue.add(map.get(current));
                }
            }
        }

        while(!queue.isEmpty())
        ans.add(queue.poll().val);

        return ans;
    }

    public static void markParents(TreeNode root, HashMap<TreeNode, TreeNode> map)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            while(size-- > 0)
            {
                TreeNode current = queue.poll();

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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        find(root, ans);

        return ans;
    }

    //Recursive solution
    /* public static void find(TreeNode root, List<Integer> ans)
    {
        if(root == null)
        return;

        find(root.left, ans);
        ans.add(root.val);
        find(root.right, ans);
    } */

    //Iterative Solution using stack
    public static void find(TreeNode root, List<Integer> ans)
    {
        if(root == null)
        return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while(true)
        {
            if(currentNode != null)
            {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            else
            {
                if(stack.isEmpty())
                break;

                currentNode = stack.pop();
                ans.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }

        return;
    }

    // Morris Traversal takes O(1) space
    /* public static void find(TreeNode root, List<Integer> ans)
    {
        TreeNode current = root;
        while(current != null)
        {
            if(current.left == null) // No left means we take the current value and move to right
            {
                ans.add(current.val);
                current = current.right;
            }

            else
            {
                TreeNode prev = current.left; // Go to the left node
                while(prev.right != null && prev.right != current) // Go to the rightmost node of the left side
                prev = prev.right;

                if(prev.right == null) // No thread exists, then connect the rightmost node of the left side to the current node and start left traversal.
                {
                    prev.right = current;
                    current = current.left;
                }

                else // If the thread is already there that means we have traversed left side, so remove the thread, add current value and move towards right.
                {
                    prev.right = null;
                    ans.add(current.val);
                    current = current.right;
                }
            }
        }

        return;
    } */

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

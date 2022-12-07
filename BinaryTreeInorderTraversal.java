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
            if(current.left == null)
            {
                ans.add(current.val);
                current = current.right;
            }

            else
            {
                TreeNode prev = current.left;
                while(prev.right != null && prev.right != current)
                prev = prev.right;

                if(prev.right == null)
                {
                    prev.right = current;
                    current = current.left;
                }

                else
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

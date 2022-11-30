import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        find(root, ans);

        return ans;
    }

    // Recursive Approach
    /* public static void find(TreeNode root, List<Integer> ans)
    {
        if(root == null)
        return;

        find(root.left, ans);
        find(root.right, ans);
        ans.add(root.val);
    } */

    //Tabulated using 2 stacks T: O(2n) S: O(2n)
    public static void find(TreeNode root, List<Integer> ans)
    {
        if(root == null)
        return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while(!stack1.isEmpty())
        {
            TreeNode currentNode = stack1.pop();
            stack2.push(currentNode); // You can also directly add it to the ans list and reverse it at the end if you don't want to use second stack.

            if(currentNode.left != null)
            stack1.push(currentNode.left);

            if(currentNode.right != null)
            stack1.push(currentNode.right);
        }

        while(!stack2.isEmpty())
        ans.add(stack2.pop().val);

        return;
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

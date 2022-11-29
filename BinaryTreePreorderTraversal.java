import java.util.*;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        find(root, ans);

        return ans;
    }

    //Recursive solution
    /* public static void find(TreeNode root, LinkedList<Integer> ans)
    {
        if(root == null)
        return;

        ans.add(root.val);
        find(root.left, ans);
        find(root.right, ans);
    } */

    //Iterative Solution using stack
    // Due to the LIFO nature of Stack, we add the right node first to the stack so that it pops out last as Preorder traversal visits the right node at last.
    public static void find(TreeNode root, LinkedList<Integer> ans)
    {
        if(root == null)
        return;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty())
        {
            TreeNode currentRoot = stack.pop();
            ans.add(currentRoot.val);

            if(currentRoot.right != null)
            stack.push(currentRoot.right);

            if(currentRoot.left != null)
            stack.push(currentRoot.left);
        }

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

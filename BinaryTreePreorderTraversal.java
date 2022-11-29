import java.util.*;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        find(root, ans);

        return ans;
    }

    public static void find(TreeNode root, LinkedList<Integer> ans)
    {
        if(root == null)
        return;

        ans.add(root.val);
        find(root.left, ans);
        find(root.right, ans);
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

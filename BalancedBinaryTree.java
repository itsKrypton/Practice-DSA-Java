public class BalancedBinaryTree {
    // Variation of maximum depth of a binary tree; For every node check if left side - right side is > 1. If it is then return 1 otherwise follow the normal procedure.
    // Add an extra condition to check if left or right is -1 in which case we return -1 denoting that it is not a balanced binary tree.
    public boolean isBalanced(TreeNode root) {
        return (maxDepth(root) == -1) ? false : true;
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
        return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if(Math.abs(left - right) > 1 || left == -1 || right == -1)
        return -1;

        return 1 + Math.max(left, right);
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

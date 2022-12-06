public class CountCompleteTreeNodes {
    /*
     * A normal traversal would take O(n) time to count all the nodes in a binary tree. In this problem we are given that the binary tree is a complete binary tree. 
     * If the complete binary tree in full, that is if the left height and right height is equal then we can calculate the number of nodes by 2^h - 1 or (1 << h) - 1.
     * That way we don't have to go further down the nodes. Else we can calculate the left height and right height for the left and right parts of the tree.
     * 
     * T: O(log n * log n)
     */
    public int countNodes(TreeNode root) {
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);

        return (leftHeight == rightHeight) ? (1 << leftHeight) - 1 : 1 + find(root.left, leftHeight - 1, rightHeight(root.left)) + find(root.right, leftHeight(root.right), rightHeight - 1);
    }

    public static int find(TreeNode root, int leftHeight, int rightHeight)
    {
        return (leftHeight == rightHeight) ? (1 << leftHeight) - 1 : 1 + find(root.left, leftHeight - 1, rightHeight(root.left)) + find(root.right, leftHeight(root.right), rightHeight - 1);
    }

    public static int leftHeight(TreeNode root)
    {
        if(root == null)
        return 0;

        return 1 + leftHeight(root.left);
    }

    public static int rightHeight(TreeNode root)
    {
        if(root == null)
        return 0;

        return 1 + rightHeight(root.right);
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

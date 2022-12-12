// https://leetcode.com/problems/recover-binary-search-tree/description/

/*
 * Inorder of a proper BST gives us a sorted array so keep checking inorder if every upcoming node is greater than the last one or not. If it's not then mark those
 * nodes. In the end just swap the value of those nodes.
 */

public class RecoverBinarySearchTree {
    private TreeNode first;
    private TreeNode second;
    private TreeNode last;

    public void recoverTree(TreeNode root) {
        last = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if(first != null && second != null)
        {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    public void inorder(TreeNode root)
    {
        if(root == null)
        return;

        inorder(root.left);

        if(root.val < last.val)
        {
            if(first == null)
            {
                first = last;
                second = root;
            }

            else
            second = root;
        }
        last = root;

        inorder(root.right);
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

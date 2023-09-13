// https://leetcode.com/problems/subtree-of-another-tree/description/

/*
 * Whenever the node values are same, check if the tree below it is same as the subtree using the isSameTree function. If it is true, return true, else continue searching
 * the rest of the tree.
 */

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        boolean left = isSubtree(root.left, subRoot);
        if(left) return true;
        boolean right = isSubtree(root.right, subRoot);
        if(right) return true;

        if(root.val == subRoot.val)
        return isSameTree(root, subRoot);

        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null)
        return (p == q);

        boolean left = isSameTree(p.left, q.left);
        if(!left) return false;
        boolean right = isSameTree(p.right, q.right);
        if(!right) return false;

        return (p.val == q.val);
    }
}

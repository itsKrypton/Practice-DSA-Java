public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null)
        return (p == q);

        // Above is a shortcut for the lower part.
        /* if(p == null && q == null)
        return true;
        
        if(p == null || q == null)
        return false; */

        boolean left = isSameTree(p.left, q.left);
        if(!left) return false;
        boolean right = isSameTree(p.right, q.right);
        if(!right) return false;

        return (p.val == q.val);

        //Can also be written as 
        // return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
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

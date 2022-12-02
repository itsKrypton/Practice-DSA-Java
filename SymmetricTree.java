public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return find(root.left, root.right);
    }

    public static boolean find(TreeNode node1, TreeNode node2)
    {
        if(node1 == null || node2 == null)
        return (node1 == node2);

        boolean left = find(node1.left, node2.right);
        if(!left) return false;
        boolean right = find(node1.right, node2.left);
        if(!right) return false;

        return (node1.val == node2.val);
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

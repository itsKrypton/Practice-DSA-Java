public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        find(root, max);
        return max[0];
    }

    public int find(TreeNode root, int[] max)
    {
        if(root == null)
        return 0;

        int left = find(root.left, max); // Or you can make sure if it's positive by Math.max(0, find(root.left, max));
        int right = find(root.right, max); // Math.max(0, find(root.right, max)) then you don't need to check it while returning.

        max[0] = Math.max(max[0], left + right + root.val);

        return (root.val + Math.max(left, right) >= 0) ? root.val + Math.max(left, right) : 0;
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

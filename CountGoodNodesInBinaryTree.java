public class CountGoodNodesInBinaryTree {

    /*
     * Just keep a track of max value till not in a traversal and increment count if the current value is greater than the max value till now.
     */

    public int goodNodes(TreeNode root) {
        return find(root, Integer.MIN_VALUE);
    }

    public int find(TreeNode root, int maxValue)
    {
        if(root == null) return 0;

        int count = 0;
        maxValue = Math.max(maxValue, root.val);

        if(root.val >= maxValue)
            count++;

        count += find(root.left, maxValue);
        count += find(root.right, maxValue);

        return count;
    }

    class TreeNode {
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

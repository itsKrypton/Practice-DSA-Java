public class CeilFromBinarySearchTree {
    public  static int findCeil(TreeNode node, int x) {
        int ceil = -1;

        while(node != null)
        {
            if(node.val == x)
            return node.val;

            if(node.val > x)
            {
                ceil = node.val;
                node = node.left;
            }

            else
            node = node.right;
        }

        return ceil;
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

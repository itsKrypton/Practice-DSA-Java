public class FloorInBinarySearchTree {
    public static int floorInBST(TreeNode root, int X) {
        int floor = -1;

        while(root != null)
        {
            if(root.val == X)
            return root.val;

            if(root.val < X)
            {
                floor = root.val;
                root = root.right;
            }

            else
            root = root.left;
        }

        return floor;
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

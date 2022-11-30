//import java.util.LinkedList;
//import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    // Recursive Approach T: O(n) S:O(1) + O(height) ASS
    public int maxDepth(TreeNode root) {
        if(root == null)
        return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    // Iterative Approach T: O(n) S: O(n)
    /* public int maxDepth(TreeNode root) {
        if(root == null)
        return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int height = 0;
        queue.add(root);

        while(!queue.isEmpty())
        {
            int currentSize = queue.size();
            height++;
            for(int i = 0; i < currentSize; i++)
            {
                if(queue.peek().left != null)
                queue.add(queue.peek().left);

                if(queue.peek().right != null)
                queue.add(queue.peek().right);

                queue.remove();
            }
        }

        return height;
    } */

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

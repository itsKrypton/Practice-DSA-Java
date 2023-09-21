// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

/*
 * Inorder of a BST is always sorted due to it's property, simply return the kth inorder value for the kth smallest value. For largest, you can do a reverse inorder
 * traversal or find number of nodes n and pass (n - k + 1) to smallest node function.
 */

import java.util.Stack;

public class KthSmallestValueInBST {
    // Iterative version T: O(n) S:O(n) for recursive stack space
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;

        while(true)
        {
            // Move left till you can
            while(current != null)
            {
                stack.push(current);
                current = current.left;
            }

            // Pop out the root and increment the count
            current = stack.pop();
            count++;

            if(count == k)
                return current.val;

            // Move to right
            current = current.right;
        }
    }

    // Recursive version T: O(n) S:O(n) for recursive stack space
    /* public int kthSmallest(TreeNode root, int k) {
        int[] temp = new int[1];
        temp[0] = k;

        return find(root, temp);
    }

    public int find(TreeNode root, int[] k)
    {
        if(root == null)
        return -1;

        int left = find(root.left, k);
        if(left >= 0) return left;

        k[0]--;
        if(k[0] == 0)
        return root.val;

        return find(root.right, k);
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

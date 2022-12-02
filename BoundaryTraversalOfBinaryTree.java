// https://www.codingninjas.com/codestudio/problems/boundary-traversal_790725?leftPanelTab=0

import java.util.*;

/*
 * Traverse through the left nodes and add it to the list except the leaf nodes. Add the leaf nodes and at last traverse through the right side nodes except the
 * leaf nodes and add it to a stack. Pop the values of the stack and add it to the list.
 */

public class BoundaryTraversalOfBinaryTree {
    public static ArrayList<Integer> traverseBoundary(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
        ans.add(root.val);

        if(isLeaf(root))
        return ans;

        findLeftNodes(root, ans);
        findLeafNodes(root, ans);
        findRightNodes(root, ans);
        return ans;
	}

    public static void findLeftNodes(TreeNode root, ArrayList<Integer> ans)
    {
        if(root.left == null)
        return;

        TreeNode currentNode = root.left;
        while(!isLeaf(currentNode))
        {
            ans.add(currentNode.val);
            currentNode = (currentNode.left == null) ? currentNode.right : currentNode.left;
        }
    }

    public static void findLeafNodes(TreeNode root, ArrayList<Integer> ans)
    {
        if(root == null)
        return;

        findLeafNodes(root.left, ans);
        findLeafNodes(root.right, ans);

        if(isLeaf(root))
        ans.add(root.val);
    }

    public static void findRightNodes(TreeNode root, ArrayList<Integer> ans)
    {
        if(root.right == null)
        return;

        TreeNode currentNode = root.right;
        Stack<Integer> stack = new Stack<>();
        while(!isLeaf(currentNode))
        {
            stack.push(currentNode.val);
            currentNode = (currentNode.right == null) ? currentNode.left : currentNode.right;
        }

        while(!stack.isEmpty())
        ans.add(stack.pop());
    }

    public static boolean isLeaf(TreeNode root)
    {
        return (root.right == null && root.left == null);
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

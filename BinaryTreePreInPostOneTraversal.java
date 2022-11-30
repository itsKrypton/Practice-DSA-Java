import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreePreInPostOneTraversal {
    public static void find(TreeNode root, LinkedList<Integer> preorder, LinkedList<Integer> inorder, LinkedList<Integer> postorder)
    {   
        if(root == null)
        return;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while(!stack.isEmpty())
        {
            Pair currentPair = stack.pop();

            if(currentPair.val == 1)
            {
                preorder.add(currentPair.node.val);
                currentPair.val++;
                stack.push(currentPair);

                if(currentPair.node.left != null)
                stack.push(new Pair(currentPair.node.left, 1));
            }

            else if(currentPair.val == 2)
            {
                inorder.add(currentPair.node.val);
                currentPair.val++;
                stack.push(currentPair);

                if(currentPair.node.right != null)
                stack.push(new Pair(currentPair.node.right, 1));
            }

            else
            postorder.add(currentPair.node.val);
        }
        
    }

    public static class TreeNode {
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

    public static class Pair
    {
        TreeNode node;
        int val;

        Pair(TreeNode node, int val)
        {
            this.node = node;
            this.val = val;
        }
    }
}

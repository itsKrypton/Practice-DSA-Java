// https://www.codingninjas.com/codestudio/problems/path-in-a-tree_3843990?leftPanelTab=0

import java.util.ArrayList;

public class PathInATree {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        find(root, x, ans);
        return ans;
    }

    public static boolean find(TreeNode root, int x, ArrayList<Integer> ans)
    {
        if(root == null)
        return false;

        if(root.val == x)
        {
            ans.add(root.val);
            return true;
        }

        ans.add(root.val);

        if(find(root.left, x, ans) || find(root.right, x, ans))
        return true;

        ans.remove(ans.size() - 1);
        return false;
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

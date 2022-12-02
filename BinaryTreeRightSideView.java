// https://leetcode.com/problems/binary-tree-right-side-view/description/

import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
import java.util.List;
//import java.util.Queue;

/*
 * Similar to bottom and top view just replace col with row. For left side view, check if the row doesn't exist already and only then insert inside the hashmap, don't
 * insert if it exists already. Using HashMap here and not TreeMap because rows are already sorted (starting from 0), thus using HashMap we will have insertions at 
 * O(1) time and not O(log n) time as in TreeMap.
 */

public class BinaryTreeRightSideView {
    /* public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null)
        return ans;

        Queue<Pair> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        queue.add(new Pair(root, 0));

        while(!queue.isEmpty())
        {
            int currentSize = queue.size();
            while(currentSize-- > 0)
            {
                Pair current = queue.poll();
            
                map.put(current.row, current.node.val);
    
                if(current.node.left != null)
                queue.add(new Pair(current.node.left, current.row + 1));
    
                if(current.node.right != null)
                queue.add(new Pair(current.node.right, current.row + 1));
            }
        }

        for(int value : map.values())
        ans.add(value);

        return ans;
    } */

    /* public static class Pair {
        TreeNode node;
        int row;

        Pair(TreeNode node, int row)
        {
            this.node = node;
            this.row = row;
        }
    } */

    // Efficient way to do it, less space and faster, here we are using reverse pre-order traversal which makes sure we go top to bottom and right side is visited 
    // first so that only that value is inserted.

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null)
        return ans;

        find(root, 0, ans);
        return ans;
    }

    public static void find(TreeNode root, int row, List<Integer> ans)
    {
        if(root == null)
        return;

        if(row == ans.size()) // When we visit a level for the first time only then an item will be inserted.
        ans.add(root.val);

        find(root.right, row + 1, ans);
        find(root.left, row + 1, ans);
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

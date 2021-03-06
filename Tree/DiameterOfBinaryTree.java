/*
 Author:     Junjie
 Date:       June 1, 2017
 Problem:    Diameter of Binary Tree
 Difficulty: Easy
 Source:     https://leetcode.com/problems/diameter-of-binary-tree/#/description
 Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 Example:
 Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 Note: The length of path between two nodes is represented by the number of edges between them.
 Solution: Divide and Conquer, Recursion, Max Depth of Tree
 时间复杂度: O(n), n为树里面node的总数
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }
    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        diameter = Math.max(diameter, leftDepth + rightDepth);
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
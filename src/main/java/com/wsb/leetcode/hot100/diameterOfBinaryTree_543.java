package com.wsb.leetcode.hot100;

public class diameterOfBinaryTree_543 {
    // 记录以当前节点为根节点的路径上经过的最大节点数。 那么 路径 = ans - 1
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;
    }
    private int depth(TreeNode root){
        if (root == null) return 0;
        int L = depth(root.left);
        int R = depth(root.right);
        // 更新ans 即遍历每个节点 寻找最大的ans （因为最长路径不一定经过根节点，所以要遍历每个节点）
        ans = Math.max(ans, L + R + 1);
        // 返回的是当前节点的左右子树高度的最大值 + 1 （即要的是 左右两边最长那条路上的节点数 然后 加上自己这个节点即+1）
        return Math.max(L, R) + 1;
    }
}

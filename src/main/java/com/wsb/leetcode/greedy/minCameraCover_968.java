package com.wsb.leetcode.greedy;

public class minCameraCover_968 {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        // 对根节点的状态做检验,防止根节点是无覆盖状态
        if (minCame(root)  == 0 ){
            res++;
        }
        return res;
    }

    private int minCame(TreeNode root) {
        /**
         节点的状态值：
         0 表示无覆盖
         1 表示有摄像头
         2 表示有覆盖
         后序遍历，根据左右节点的情况,来判读 自己的状态
         */
        if (root == null){
            // 空节点默认为有覆盖状态，避免在叶子节点上放摄像头
            return 2;
        }
        int left = minCame(root.left);
        int right = minCame(root.right);
        // 如果左右节点都覆盖了的话, 那么本节点的状态就应该是无覆盖,没有摄像头
        if (left == 2 && right == 2){
            return 0;
        }else if (left == 0 || right == 0){
            // 左右节点都是无覆盖状态,那根节点此时应该放一个摄像头
            res++;
            return 1;
        }else {
            // 左右节点的 状态为 (1,1) (1,2) (2,1) 也就是左右节点至少存在 1个摄像头，那么本节点就是处于被覆盖状态
            return 2;
        }
    }
}

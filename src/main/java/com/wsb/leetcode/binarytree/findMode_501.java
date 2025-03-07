package com.wsb.leetcode.binarytree;

import java.util.*;
import java.util.stream.Collectors;

public class findMode_501 {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list.stream().mapToInt(Integer::intValue).toArray();
        searchBST(root, map);
        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .collect(Collectors.toList());
        list.add(mapList.get(0).getKey());
        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i).getValue() == mapList.get(i - 1).getValue()) {
                list.add(mapList.get(i).getKey());
            }else {
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }

    private void searchBST(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        searchBST(root.left, map);
        searchBST(root.right, map);
    }

    ArrayList<Integer> resList;
    int maxCount;
    int count;
    TreeNode pre;
    public int[] findMode1(TreeNode root){
        resList = new ArrayList<>();
        pre = null;
        count = 0;
        maxCount = 0;
        findMode2(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    private void findMode2(TreeNode root) {
        if (root == null) return;
        findMode2(root.left);
        if (pre == null || root.val != pre.val){
            count = 1;
        }else
            count++;
        if (count > maxCount){
            resList.clear();
            resList.add(root.val);
            maxCount = count;
        }else if (count == maxCount){
            resList.add(root.val);
        }
        pre = root;
        findMode2(root.right);
    }

//    public static void main(String[] args) {
//        TreeNode left1 = new TreeNode(2);
//        TreeNode right1 = new TreeNode(2, left1, null);
//        TreeNode root = new TreeNode(1, null, right1);
//        findMode_501 test = new findMode_501();
//        System.out.println(Arrays.toString(test.findMode(root)));
//
//    }
}
